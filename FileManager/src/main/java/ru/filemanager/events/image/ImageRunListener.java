package ru.filemanager.events.image;

import ru.filemanager.UI;
import ru.filemanager.algorithms.Algorithms;

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

    public ImageRunListener(UI ui) {
        this.ui = ui;
    }

    private void setLeftImg(BufferedImage img) {
        ui.getImageLabelLeft().setIcon(new ImageIcon(img));
    }

    private void setRightImg(BufferedImage img) {
        ui.getImageLabelRight().setIcon(new ImageIcon(img));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Очищаем поля вывода
        ui.getImageLabelLeft().setIcon(new ImageIcon(""));
        ui.getImageLabelRight().setIcon(new ImageIcon(""));

        //Получаем исходное изображение
        BufferedImage originalImage = ui.getImage();
        //Создаём обработанное изображение
        BufferedImage newImage;

        //Получаем список возможных действий
        String radioCase = ui.getGroupRadioButtons().getSelection().getActionCommand();

        if (radioCase.equals("maxwell")) {
            newImage = Algorithms.maxwellAlhoritm();
            setRightImg(newImage);
            return;
        } else if (radioCase.equals("grey")) {
            setLeftImg(originalImage);
            newImage = Algorithms.greyAlhoritm(originalImage);
            setRightImg(newImage);
            return;
        } else if (radioCase.equals("wave_1")) {
            setLeftImg(originalImage);
            newImage = Algorithms.waveAlhoritm_1(originalImage);
            setRightImg(newImage);
            return;
        } else if (radioCase.equals("wave_2")) {
            setLeftImg(originalImage);
            newImage = Algorithms.waveAlhoritm_2(originalImage);
            setRightImg(newImage);
            return;
        } else if (radioCase.equals("correlation")) {
            BufferedImage faces = null;
            BufferedImage face = null;
            try {
                faces = (ImageIO.read(new File("src/main/resources/faces.jpg")));
                face = (ImageIO.read(new File("src/main/resources/face.jpg")));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            setLeftImg(faces);
            newImage = Algorithms.correlation(faces, face);
            setRightImg(newImage);
            return;
        } else if (radioCase.equals("borders")) {
            setLeftImg(originalImage);
            newImage = Algorithms.bordersAlgorithm(originalImage);
            setRightImg(newImage);
            return;
        }
    }
}
