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
                ui.setImage(ImageIO.read(new File("src/main/resources/faces.png")));
                ui.getImageLabelLeft().setIcon(new ImageIcon(ui.getImage()));
                newImage = new BufferedImage(ui.getImage().getWidth(), ui.getImage().getHeight(), BufferedImage.TYPE_INT_RGB);

                BufferedImage faces = ui.getImage();
                ui.setImage(ImageIO.read(new File("src/main/resources/face.png")));
                BufferedImage face = ui.getImage();

                korrelationAlhoritm(faces, face);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            ui.getImageLabelRight().setIcon(new ImageIcon(newImage));
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

//    private void korrelationAlhoritm(BufferedImage faces, BufferedImage face) {
//        int HG = face.getHeight();
//        int WG = face.getWidth();
//        int HF = faces.getHeight();
//        int WF = faces.getWidth();
//    }

    /*int [][] svertka = {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1}
        };

        //ВЫДЕЛЕНИЕ ГРАНИЦ
        for (int  y = 1; y < HG - 1; y++) {
            for (int x = 1; x < WG - 1; x++) {
                sum = 0;
                for (int j = 0; j < 3; j++) {
                    for (int i = 0; i < 3; i++) {
                        pixelColorG = new Color(face.getRGB(x - 1 + i, y - 1 + j));
                        brightnessPixelG = (pixelColorG.getRed() + pixelColorG.getBlue() + pixelColorG.getGreen()) / 3;
                        sum += brightnessPixelG * svertka[j][i];
                    }
                }
                if (sum < 0)
                    sum = 0;
                if (sum > 255)
                    sum = 255;
                Color color = new Color((int)sum, (int)sum, (int)sum);
                newImage.setRGB(x, y, color.getRGB());
            }
        }*/

    /**
     * Алгоритм распознавания избражения
     */
    private void korrelationAlhoritm(BufferedImage faces, BufferedImage face) {
        int HG = face.getHeight();
        int WG = face.getWidth();
        int HF = faces.getHeight();
        int WF = faces.getWidth();

        float sum = 0;
        int max = -1;
        Color pixelColorG;
        Color pixelColorF;
        float brightnessPixelG;
        float brightnessPixelF;

        BufferedImage faceBorder= new BufferedImage(face.getWidth(), face.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage facesBorder= new BufferedImage(faces.getWidth(), faces.getHeight(), BufferedImage.TYPE_INT_RGB);

        int [][] svertka = {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1}
        };
        //ВЫДЕЛЕНИЕ ГРАНИЦ У ШАБЛОНА
        for (int  y = 1; y < HG - 1; y++) {
            for (int x = 1; x < WG - 1; x++) {
                sum = 0;
                for (int j = 0; j < 3; j++) {
                    for (int i = 0; i < 3; i++) {
                        pixelColorG = new Color(face.getRGB(x - 1 + i, y - 1 + j));
                        brightnessPixelG = (pixelColorG.getRed() + pixelColorG.getBlue() + pixelColorG.getGreen()) / 3;
                        sum += brightnessPixelG * svertka[j][i];
                    }
                }
                if (sum < 0)
                    sum = 0;
                if (sum > 255)
                    sum = 255;
                if (max < sum)
                    max = (int)sum;
                Color color = new Color((int)sum, (int)sum, (int)sum);
                faceBorder.setRGB(x, y, color.getRGB());
            }
        }



        //ВЫДЕЛЕНИЕ ГРАНИЦ У ИСХОДНИКА
        for (int  y = 1; y < HF - 1; y++) {
            for (int x = 1; x < WF - 1; x++) {
                sum = 0;
                for (int j = 0; j < 3; j++) {
                    for (int i = 0; i < 3; i++) {
                        pixelColorF = new Color(faces.getRGB(x - 1 + i, y - 1 + j));
                        brightnessPixelF = (pixelColorF.getRed() + pixelColorF.getBlue() + pixelColorF.getGreen()) / 3;
                        sum += brightnessPixelF * svertka[j][i];
                    }
                }
                if (sum < 0)
                    sum = 0;
                if (sum > 255)
                    sum = 255;
                if (max < sum)
                    max = (int)sum;
                Color color = new Color((int)sum, (int)sum, (int)sum);
                facesBorder.setRGB(x, y, color.getRGB());
            }
        }


        max = -1;
        BufferedImage result= new BufferedImage(faces.getWidth(), faces.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = HG / 2; y < HF - (HG / 2) ; y++) {
            for (int x = WG / 2; x < WF - (WG / 2); x++) {
                sum = 0;
                for (int j = 0; j < HG; j++) {
                    for (int i = 0; i < WG; i++) {
                        pixelColorG = new Color(faceBorder.getRGB(i , j));
                        pixelColorF = new Color(facesBorder.getRGB( x - (WG / 2) + i, y - (HG / 2) + j));
                        //Яркость каждого пикселя
                        brightnessPixelG = (pixelColorG.getRed() + pixelColorG.getBlue() + pixelColorG.getGreen()) / 3;
                        brightnessPixelF = (pixelColorF.getRed() + pixelColorF.getBlue() + pixelColorF.getGreen()) / 3;
                        sum += brightnessPixelG * brightnessPixelF;
                    }
                }
                sum = 255 / sum;
                Color color = new Color((int)sum, (int)sum, (int)sum);
                result.setRGB(x, y, color.getRGB());
                //System.out.println();
            }
        }
        newImage = result;

    }
}
