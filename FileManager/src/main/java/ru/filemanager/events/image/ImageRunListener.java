package ru.filemanager.events.image;

import ru.filemanager.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ImageRunListener implements ActionListener {
    private UI ui;
    private BufferedImage newImage;

    public ImageRunListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ui.getImage() != null) {
            newImage = new BufferedImage(ui.getImage().getWidth(), ui.getImage().getHeight(), BufferedImage.TYPE_INT_RGB);
            String radioCase = ui.getGroupRadioButtons().getSelection().getActionCommand();
            if (radioCase.equals("grey"))
                greyAlhoritm();
            else if (radioCase.equals("wave_1"))
                waveAlhoritm_1();
            else if (radioCase.equals("wave_2"))
                waveAlhoritm_2();
            else if (radioCase.equals("maxwell"))
                maxwellAlhoritm();
            ui.getImageLabelRight().setIcon(new ImageIcon(newImage));
        }
    }

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

    private void waveAlhoritm_2() {
        double u = 0.1, v = 0, a = 0.005;
        for (int y = 0; y < ui.getImage().getHeight(); y++) {
            for (int x = 0; x < ui.getImage().getWidth(); x++) {
                //u = a * x;
                int br = (int)(128 + 50 * Math.cos(u * x + v * y));
                Color color = new Color(br, br, br);
                newImage.setRGB(x, y, color.getRGB());
            }
        }
    }

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
}
