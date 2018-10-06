package ru.filemanager.events.image;

import ru.filemanager.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageClearListener implements ActionListener {
    private UI ui;

    public ImageClearListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.getImageLabelLeft().setIcon(new ImageIcon(""));
        ui.getImageLabelRight().setIcon(new ImageIcon(""));
    }
}
