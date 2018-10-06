package ru.filemanager.events.image;

import ru.filemanager.UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ImageLoadListener implements ActionListener {
    private UI ui;

    public ImageLoadListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("Выберите изображение: ");
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = jFileChooser.showOpenDialog(ui);
        if (result == JFileChooser.APPROVE_OPTION) {
            ui.setSelectedFile(new File(jFileChooser.getSelectedFile().getAbsolutePath()));
        }
        try {
            ui.setImage(ImageIO.read(ui.getSelectedFile()));
            ui.getImageLabelLeft().setIcon(new ImageIcon(ui.getImage()));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
