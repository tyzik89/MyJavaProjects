package ru.filemanager.events.image;

import ru.filemanager.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ImageRunListener implements ActionListener {
    private UI ui;

    public ImageRunListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ui.getImage() != null) {
            BufferedImage newImage = new BufferedImage(ui.getImage().getWidth(), ui.getImage().getHeight(), BufferedImage.TYPE_INT_RGB);
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
            ui.getImageLabelRight().setIcon(new ImageIcon(newImage));
        }
    }
}
