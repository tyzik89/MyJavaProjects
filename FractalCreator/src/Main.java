import fractal.AttractorOfLorenz;
import fractal.Fractal;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Main {

    private final static int size = 2048;

    public static void main(String[] args) {
        FileInputStream stream;
        Properties property = new Properties();

        try {
            String configPath = args[0];
            stream = new FileInputStream(configPath);
            property.load(stream);

            String savePath = property.getProperty("path_to_save");
            String extension = property.getProperty("extension");
            Double sigma = Double.parseDouble(property.getProperty("sigma"));
            Double r = Double.parseDouble(property.getProperty("r"));
            Double dt = Double.parseDouble(property.getProperty("dt"));
            Double x = Double.parseDouble(property.getProperty("x"));
            Double y = Double.parseDouble(property.getProperty("y"));
            Double z = Double.parseDouble(property.getProperty("z"));
            Integer iterations = Integer.parseInt(property.getProperty("iterations"));
            String background_color = property.getProperty("background_color");
            String attractor_color = property.getProperty("attractor_color");

            Fractal fractal =
                    new AttractorOfLorenz.Builder(iterations)
                            .setSigma(sigma)
                            .setDT(dt)
                            .setR(r)
                            .setX(x)
                            .setY(y)
                            .setZ(z)
                            .build();
            int[][] result = fractal.create(size, size);

            BufferedImage bufferImage2 = new BufferedImage(size, size, "png".equals(extension.toLowerCase()) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);

            Color curr_attractor_color;
            try {
                Field field = Color.class.getField(attractor_color);
                curr_attractor_color = (Color) field.get(null);
            } catch (Exception e) {
                curr_attractor_color = Color.WHITE; // Not defined
            }
            Color curr_background_color;
            try {
                Field field = Color.class.getField(background_color);
                curr_background_color = (Color) field.get(null);
            } catch (Exception e) {
                curr_background_color = Color.BLACK; // Not defined
            }

            for(int y_coord = 0; y_coord < size; y_coord++){
                for(int x_coord = 0; x_coord < size; x_coord++){
//                    int argb = alpha << 24 + red << 16 + green << 8 + blue
//                    int pixel = result[x_coord][y_coord] << 16 | result[x_coord][y_coord] << 8 | result[x_coord][y_coord];
                    int pixel = result[x_coord][y_coord] != 1 ? curr_background_color.getRGB() : curr_attractor_color.getRGB();
                    bufferImage2.setRGB(x_coord, y_coord, pixel);
                }
            }

            File outputfile = new File(savePath + System.currentTimeMillis() + "." + extension);
            System.out.println(outputfile);
            try {
                ImageIO.write(bufferImage2, extension, outputfile);
            } catch (FileNotFoundException e) {
                System.err.println("Error: Unable to save file! Please correct the path in config file.");
            } catch (IOException e) {
                System.err.println("Error: Unable to save file!");
            }
        } catch (IOException e) {
            System.err.println("Error: config not found! Please input correct path.");
        }
    }
}
