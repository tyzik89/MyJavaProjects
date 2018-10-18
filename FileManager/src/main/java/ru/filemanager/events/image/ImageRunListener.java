package ru.filemanager.events.image;

import ru.filemanager.UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRunListener implements ActionListener {
    private UI ui;
    private BufferedImage newImage;

    public ImageRunListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isLoad = false;
        if (ui.getImage() != null) {
            isLoad = true;
            newImage = new BufferedImage(ui.getImage().getWidth(), ui.getImage().getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        String radioCase = ui.getGroupRadioButtons().getSelection().getActionCommand();
        if (radioCase.equals("grey") && isLoad) {
            ui.getImageLabelLeft().setIcon(new ImageIcon(ui.getImage()));
            greyAlhoritm();
            ui.getImageLabelRight().setIcon(new ImageIcon(newImage));
        } else if (radioCase.equals("wave_1") && isLoad) {
            ui.getImageLabelLeft().setIcon(new ImageIcon(ui.getImage()));
            waveAlhoritm_1();
            ui.getImageLabelRight().setIcon(new ImageIcon(newImage));
        } else if (radioCase.equals("wave_2") && isLoad) {
            ui.getImageLabelLeft().setIcon(new ImageIcon(ui.getImage()));
            waveAlhoritm_2();
            ui.getImageLabelRight().setIcon(new ImageIcon(newImage));
        } else if (radioCase.equals("maxwell")) {
            ui.getImageLabelLeft().setIcon(new ImageIcon(""));
            ui.getImageLabelRight().setIcon(new ImageIcon(""));
            maxwellAlhoritm();
            ui.getImageLabelRight().setIcon(new ImageIcon(newImage));
        } else if (radioCase.equals("korrelation")) {
            try {
                ui.setImage(ImageIO.read(new File("src/main/resources/faces.jpg")));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            ui.getImageLabelLeft().setIcon(new ImageIcon(ui.getImage()));
            ui.getImageLabelRight().setIcon(new ImageIcon(korrelationAlhoritm()));
        }

    }

    /**
     * Градации серого
     */
    private void greyAlhoritm() {
        for (int y = 0; y < ui.getImage().getHeight(); y++) {
            for (int x = 0; x < ui.getImage().getWidth(); x++) {
                int rgb = ui.getImage().getRGB(x, y);
                Color color = new Color(ui.getImage().getRGB(x, y));
                int red = color.getRed();
                int blue = color.getBlue();
                int green = color.getGreen();
                int grey = (red + green + blue) / 3;
                Color greyColor = new Color(grey, grey, grey);
                newImage.setRGB(x, y, greyColor.getRGB());
            }
        }
    }

    private void waveAlhoritm_1() {
        double u = 0.2, v = 0;
        for (int y = 0; y < ui.getImage().getHeight(); y++) {
            for (int x = 0; x < ui.getImage().getWidth(); x++) {
                int br = (int)(128 + 50 * Math.cos(u * x + v * y));
                Color color = new Color(br, br, br);
                newImage.setRGB(x, y, color.getRGB());
            }
        }
    }

    /**
     * Теорема Котельникова
     */
    private void waveAlhoritm_2() {
        double u = 0.1, v = 0, a = 0.005;
        for (int y = 0; y < ui.getImage().getHeight(); y++) {
            for (int x = 0; x < ui.getImage().getWidth(); x++) {
                u = a * x;
                int br = (int)(128 + 50 * Math.cos(u * x + v * y));
                Color color = new Color(br, br, br);
                newImage.setRGB(x, y, color.getRGB());
            }
        }
    }

    /**
     * Построение треугольника Максвелла
     */
    private void maxwellAlhoritm() {
        newImage = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
        for (int g = 0; g < 256; g++) {
            for (int r = 0; r < 256 - g; r++) {
                int b = 255 - r - g;
                Color color = new Color(r, g, b);
                newImage.setRGB(r, g, color.getRGB());
            }
        }
    }

    /**
     * Алгоритм распознавания избражения
     */
    private BufferedImage korrelationAlhoritm() {
        /*% h = f(260:475,725:940);
            h = f(500:700,725:940);*/
        BufferedImage faces = ui.getImage();
        BufferedImage facesKorrelation = new BufferedImage(faces.getWidth(), faces.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage face = faces.getSubimage(750, 500, 150, 150);
        //Алгоритм
        int HG = face.getHeight();
        int WG = face.getWidth();
        int HF = faces.getHeight();
        int WF = faces.getWidth();

        for (int y = HG / 2; y < HF - (HG / 2) ; y++) {
            for (int x = WG / 2; x < WF - (WG / 2) ; x++) {
                double sum = 0;
                for (int j = 0; j < HG; j++) {
                    for (int i = 0; i < WG; i++) {
                        int pixelG = face.getRGB(j, i);
                        int pixelF = faces.getRGB(y - (HG / 2) + j, x - (WG / 2) + i);
                        sum += pixelG * pixelF;
                    }
                }
                facesKorrelation.setRGB(y, x, (int)sum);
            }
        }
        return facesKorrelation;
    }
}
