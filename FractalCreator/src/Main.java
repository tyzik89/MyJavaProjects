import fractal.AttractorOfLorenz;
import fractal.Fractal;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.*;
import java.util.List;

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
            Integer iterations = Integer.parseInt(property.getProperty("iterations"));
            String background_color = property.getProperty("background_color");
            String attractor_color = property.getProperty("attractor_color");
            Double angle_of_rotation = Double.parseDouble(property.getProperty("angle_of_rotation"));

            Integer count_threads = Integer.parseInt(property.getProperty("count_threads"));
            if (count_threads <= 0) return;

            ArrayList<Integer[][]> resultList = new ArrayList<>();

            // Определяем пул из потоков
            ExecutorService executor = Executors.newFixedThreadPool(count_threads);
            // Список ассоциированных с Callable задач Future
            List<Future<Integer[][]>>  futures = new ArrayList<Future<Integer[][]>>();
            for (int i = 0; i < count_threads; i++) {
                double x = Double.parseDouble(property.getProperty("x" + (i + 1)));
                double y = Double.parseDouble(property.getProperty("y" + (i + 1)));
                double z = Double.parseDouble(property.getProperty("z" + (i + 1)));
                System.out.println("x=" + x + " y=" + y + " z=" + z);

                // Создание экземпляра Callable класса
                Callable<Integer[][]> fractal =
                        new AttractorOfLorenz.Builder(iterations, size)
                                .setSigma(sigma)
                                .setDT(dt)
                                .setR(r)
                                .setX(x)
                                .setY(y)
                                .setZ(z)
                                .build();
                //Стартуем возвращаюший результат исполнения
                //в виде объекта Future поток
                Future<Integer[][]> future = executor.submit(fractal);
                /*
                 * Добавляем объект Future в список для
                 * отображения результата выполнения
                 */
                futures.add(future);
            }

            for ( Future<Integer[][]> future : futures){
                try {
                    resultList.add(future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            executor.shutdown();

            BufferedImage bufferImage = new BufferedImage(size, size, "png".equals(extension.toLowerCase()) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);

            Color curr_attractor_color;
            try {
                Field field = Color.class.getField(attractor_color);
                curr_attractor_color = (Color) field.get(null);
            } catch (Exception e) {
                System.out.println("Color not defined");
                curr_attractor_color = Color.WHITE; // Not defined
            }
            Color curr_background_color;
            try {
                Field field = Color.class.getField(background_color);
                curr_background_color = (Color) field.get(null);
            } catch (Exception e) {
                System.out.println("Color not defined");
                curr_background_color = Color.BLACK; // Not defined
            }

            for (Integer[][] result : resultList) {
                for(int y_coord = 0; y_coord < size; y_coord++){
                    for(int x_coord = 0; x_coord < size; x_coord++){
//                    int argb = alpha << 24 + red << 16 + green << 8 + blue
//                    int pixel = result[x_coord][y_coord] << 16 | result[x_coord][y_coord] << 8 | result[x_coord][y_coord];
                        int pixel = result[x_coord][y_coord] == null ? curr_background_color.getRGB() : curr_attractor_color.getRGB();
                        int currPixel = bufferImage.getRGB(x_coord, y_coord);
                        if (currPixel != curr_attractor_color.getRGB()) {
                            bufferImage.setRGB(x_coord, y_coord, pixel);
                        }
                    }
                }
            }

            File outputfile = new File(savePath + System.currentTimeMillis() + "." + extension);
            System.out.println(outputfile);

            BufferedImage bufferImageRotated = rotateImage(bufferImage, angle_of_rotation, curr_background_color, extension);

            try {
                ImageIO.write(bufferImageRotated, extension, outputfile);
            } catch (FileNotFoundException e) {
                System.err.println("Error: Unable to save file! Please correct the path in config file.");
            } catch (IOException e) {
                System.err.println("Error: Unable to save file!");
            }
        } catch (IOException e) {
            System.err.println("Error: config not found! Please input correct path.");
        }
    }

    private static BufferedImage rotateImage(BufferedImage buffImage, double angle, Color color, String extension) {
        double radian = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(radian));
        double cos = Math.abs(Math.cos(radian));
        int width = buffImage.getWidth();
        int height = buffImage.getHeight();
        int nWidth = (int) Math.floor((double) width * cos + (double) height * sin);
        int nHeight = (int) Math.floor((double) width * sin + (double) height * cos);
        BufferedImage rotatedImage = new BufferedImage(nWidth, nHeight, "png".equals(extension.toLowerCase()) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = rotatedImage.createGraphics();
        graphics.setColor(color);
        graphics.fillRect(0, 0, nWidth, nHeight);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics.translate((nWidth - width) / 2, (nHeight - height) / 2);
        graphics.rotate(radian, (double) (width / 2), (double) (height / 2));
        graphics.drawImage(buffImage, 0, 0,null);
        graphics.dispose();
        return rotatedImage;
    }
}
