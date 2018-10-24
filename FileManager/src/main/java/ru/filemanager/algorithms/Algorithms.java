package ru.filemanager.algorithms;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Algorithms {

    /**
     * Изображение в градациях серого
     * @param image входное цветное изображение
     * @return изоброажение в градациях серого
     */
    public static BufferedImage greyAlhoritm(BufferedImage image) {
        BufferedImage tempImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        int pixel;
        int red, green, blue, alpha;
        int avg;
        Color greyColor;

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                pixel = image.getRGB(x, y);

                alpha = (pixel >> 24) & 0xff;
                red = (pixel >> 16) & 0xff;
                green = (pixel >> 8) & 0xff;
                blue = (pixel) & 0xff;

                avg = (red + green + blue) / 3;
                greyColor = new Color(avg, avg, avg);
                tempImg.setRGB(x, y, greyColor.getRGB());
            }
        }
        return tempImg;
    }

    /**
     * Волновой алгоритм №1
     * @param image
     * @return
     */
    public static BufferedImage waveAlhoritm_1(BufferedImage image, double u, double v) {
        BufferedImage tempImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color color;

        for (int y = 0; y <image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int br = (int)(128 + 50 * Math.cos(u * x + v * y));
                color = new Color(br, br, br);
                tempImg.setRGB(x, y, color.getRGB());
            }
        }
        return tempImg;
    }

    /**
     * Волновой алгоритм №1 с параметрами по умолчанию
     * @param image
     * @return
     */
    public static BufferedImage waveAlhoritm_1(BufferedImage image) {
        return waveAlhoritm_1(image, 0.2 , 0);
    }


    /**
     * Теорема Котельникова
     * @param image
     * @return
     */
    public static BufferedImage waveAlhoritm_2(BufferedImage image, double u, double v, double a) {
        BufferedImage tempImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color color;

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                u = a * x;
                int br = (int)(128 + 50 * Math.cos(u * x + v * y));
                color = new Color(br, br, br);
                tempImg.setRGB(x, y, color.getRGB());
            }
        }
        return tempImg;
    }

    /**
     * Теорема Котельникова с параметрами по умолчанию
     * @param image
     * @return
     */
    public static BufferedImage waveAlhoritm_2(BufferedImage image) {
        return waveAlhoritm_2(image, 0.1, 0.0, 0.005);
    }

    /**
     * Построение треугольника Максвелла
     * @return
     */
    public static BufferedImage maxwellAlhoritm() {
        BufferedImage tempImg = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
        Color color;
        for (int green = 0; green < 256; green++) {
            for (int red = 0; red < 256 - green; red++) {
                int blue = 255 - red - green;
                color = new Color(red, green, blue);
                tempImg.setRGB(red, green, color.getRGB());
            }
        }
        return tempImg;
    }

    /**
     * Корреляция двух изображений
     * @param faces
     * @param face
     * @return
     */
    public static BufferedImage correlation(BufferedImage faces, BufferedImage face) {
        BufferedImage tempImg = new BufferedImage(faces.getWidth(), faces.getHeight(), BufferedImage.TYPE_INT_RGB);
        int HG = face.getHeight();
        int WG = face.getWidth();
        int HF = faces.getHeight();
        int WF = faces.getWidth();
        double sum, max = 0.0;
        double[][] mass = new double[WF][HF];
        Color pixelColorG;
        Color pixelColorF;
        double brightnessPixelG;
        double brightnessPixelF;

        for (int y = HG / 2; y < HF - (HG / 2) ; y++) {
            for (int x = WG / 2; x < WF - (WG / 2); x++) {
                sum = 0;
                for (int j = 0; j < HG; j++) {
                    for (int i = 0; i < WG; i++) {
                        pixelColorG = new Color(face.getRGB(i , j));
                        pixelColorF = new Color(faces.getRGB( x - (WG / 2) + i, y - (HG / 2) + j));
                        //Яркость каждого пикселя
                        brightnessPixelG = (pixelColorG.getRed() + pixelColorG.getBlue() + pixelColorG.getGreen()) / 3;
                        brightnessPixelF = (pixelColorF.getRed() + pixelColorF.getBlue() + pixelColorF.getGreen()) / 3;
                        sum += brightnessPixelG * brightnessPixelF;
                    }
                }
                if (max < sum)
                    max = sum;
                mass[x][y] = sum;
            }
        }

        for (int j = HG / 2; j < HF - (HG / 2); j++) {
            for (int i = WG / 2; i < WF - (WG / 2); i++) {
                double val = mass[i][j];
                //Нормируем каждый пиксель
                val = val / max * 255;
                Color color = new Color((int)val, (int)val, (int)val);
                tempImg.setRGB(i, j, color.getRGB());
            }
        }
        return tempImg;
    }

    /**
     * Алгоритм выделения границ
     * @param img
     * @return
     */
    public static BufferedImage bordersAlgorithm(BufferedImage img) {
        int imageH = img.getHeight(), imageW = img.getWidth();
        BufferedImage tempImg = new BufferedImage(imageW, imageH, BufferedImage.TYPE_INT_RGB);
        Color pixelColor;
        int brightnessPixel;
        int sum;
        int pixel, red, green, blue, alpha;
        int [][] svertka = {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1}};
            for (int  y = 1; y < imageH - 1; y++) {
                for (int x = 1; x < imageW - 1; x++) {
                    sum = 0;
                    for (int j = 0; j < 3; j++) {
                        for (int i = 0; i < 3; i++) {
                            pixel = img.getRGB(x - 1 + i, y - 1 + j);
                            alpha = (pixel >> 24) & 0xff;
                            red = (pixel >> 16) & 0xff;
                            green = (pixel >> 8) & 0xff;
                            blue = (pixel) & 0xff;
                            brightnessPixel = (red + green + blue) / 3;
                            sum += brightnessPixel * svertka[j][i];
                        }
                    }
                    if (sum < 0)
                        sum = 0;
                    if (sum > 255)
                        sum = 255;
                    pixelColor = new Color((int)sum, (int)sum, (int)sum);
                    tempImg.setRGB(x, y, pixelColor.getRGB());
                }
            }
        return tempImg;
    }
}