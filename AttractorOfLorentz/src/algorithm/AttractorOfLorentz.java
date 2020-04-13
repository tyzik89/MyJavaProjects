package algorithm;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import utils.ImageUtils;
import utils.ShowImage;

public class AttractorOfLorentz {

    public void run() {
        Mat resultMat = new Mat(700, 700, CvType.CV_8UC1, new Scalar(0));

        double x = 3.051522, y = 1.582542, z = 15.62388, x1, y1, z1;
        double dt = 0.0001;
        int a = 5, b = 15, c = 1;

        int step = 1000000;
        int col, row;

        while (step > 0) {
            step--;
            x1 = x + a * (-x + y) * dt;
            y1 = y + (b * x - y - z * x) * dt;
            z1 = z + (-c * z + x * y) * dt;
            x = x1;
            y = y1;
            z = z1;

            row = (int) Math.round(19.3 * (y - x * 0.292893) + 320);
            col = (int) Math.round(-11 * (z + x * 0.292893) + 392);

//            System.out.println("row = " + row + " ,col = " + col);

            resultMat.put( row, col, 255.0);
        }

        save(resultMat);
        ShowImage.show(ImageUtils.matToImageFX(resultMat));
    }

    private void save(Mat resultMat) {
        boolean st = Imgcodecs.imwrite("src/result.png", resultMat);
        if (!st) {
            System.out.println("Не удалось сохранить изображение");
        }
    }
}
