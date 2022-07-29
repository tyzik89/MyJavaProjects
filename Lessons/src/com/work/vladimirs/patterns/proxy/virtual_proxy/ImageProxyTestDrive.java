package com.work.vladimirs.patterns.proxy.virtual_proxy;

import javax.swing.*;

public class ImageProxyTestDrive {

    //ImageComponent imageComponent;

    public static void main (String[] args) throws Exception {
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }

    public ImageProxyTestDrive() throws Exception {

        // Создание панели и меню.....

        // Создаем заместитель и связываем его с исходным URL-адресом. Каждый раз, когда вы выбираете
        // один из пунктов меню Album, вы получаете новый объект ImageProxy.
        //Icon icon = new ImageProxy(initialURL);
        // Затем заместитель упаковывается в компонент для добавления к объектам панели.
        //imageComponent = new ImageComponent(icon);
        // Добавляем заместитель к объ ектам панели, на которой должно выводиться изображение.
        //frame.getContentPane().add(imageComponent);
    }
}
