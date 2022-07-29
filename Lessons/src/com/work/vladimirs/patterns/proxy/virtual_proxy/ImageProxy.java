package com.work.vladimirs.patterns.proxy.virtual_proxy;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxy implements Icon {

    /**
     * В переменной imageIcon хранится НАСТОЯЩИЙ объект Icon, который должен отображаться после
     * загрузки.
     */
    volatile ImageIcon imageIcon;
    final URL imageURL;
    Thread retrievalThread;
    boolean retrieving = false;

    /**
     * Конструктору передается URL-адрес изображения — того, которое должно отображаться после загрузки.
     */
    public ImageProxy(URL url) {
        imageURL = url;
    }

    /**
     * Здесь происходит самое интересное. Изображение прорисовывается на экране (вызов делегируется
     * imageIcon). Но если объект ImageIcon еще не создан, мы создаем его.
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        } else {
            g.drawString("Loading album cover, please wait...", x+300, y+190);
            if (!retrieving) {
                retrieving = true;
                retrievalThread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            setImageIcon(new ImageIcon(imageURL, "Album Cover"));
                            c.repaint();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                retrievalThread.start();
            }
        }
    }

    /**
     * До завершения загрузки возвращаются значения длины и ширины по умолчанию (800x600); затем
     * управление передается imageIcon.
     */
    @Override
    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }

    /**
     * До завершения загрузки возвращаются значения длины и ширины по умолчанию (800x600); затем
     * управление передается imageIcon.
     */
    @Override
    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
            return 600;
        }
    }

    /**
     * imageIcon используется разными потоками, поэтому кроме объявления переменной
     * с модификатором volatile (для защиты операций чтения) мы используем синхронизированный
     * метод записи (для защиты операций записи).
     */
    synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}
