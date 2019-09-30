package models.algorithms;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;
import utils.ImageUtils;

/**
 * Преобразование Хафа (Hough Transform) — это метод для поиска линий, кругов и других простых форм на изображении.
 *
 * Преобразование Хафа предназначено для поиска объектов, принадлежащих определённому классу фигур с использованием процедуры голосования.
 * Процедура голосования применяется к пространству параметров,
 * из которого и получаются объекты определённого класса фигур по локальному максимуму в так называемом,
 * накопительном пространстве (accumulator space) которое строится при вычислении трансформации Хафа.
 */
public class HoughConversionAlgorithm implements Algorithm {

    private boolean typeHoughMethodClassic;

    // Разрешение параметра r в пикселях
    private double distance;
    // Разрешение параметра θ в радианах
    private double angle;
    // Минимальное количество пересечений(голосов), чтобы "обнаружить" линию
    private int threshold;

    private double srn = 0.0;
    private double stn = 0.0;
    private double minTheta = 0.0;
    private double maxTheta = Math.PI;

    private double minLineLength = 0.0;
    private double maxLineGap = 0.0;

    public HoughConversionAlgorithm(boolean typeHoughMethod, double distance,  double angle, int threshold, double ... params) {
        this.typeHoughMethodClassic = typeHoughMethod;
        this.distance = distance;
        this.angle = angle;
        this.threshold = threshold;

        if (typeHoughMethodClassic) {
            this.srn = params[0];
            this.stn = params[1];
            this.minTheta = params[2];
            this.maxTheta = params[3];
        } else {
            this.minLineLength = params[0];
            this.maxLineGap = params[1];
        }
    }

    @Override
    public Mat doAlgorithm(Mat frame) {
        //Конвертируем изображение в одноканальное
        Mat matGray = new Mat();
        Imgproc.cvtColor(frame, matGray, Imgproc.COLOR_BGR2GRAY);
        //Вектор, который будет хранить параметры (r, θ) обнаруженных линий
        Mat lines = new Mat();
        //Результирующая матрица линий
        Mat result = new Mat(frame.size(), CvType.CV_8UC3, ImageUtils.COLOR_WHITE);

        if (typeHoughMethodClassic) {
            Imgproc.HoughLines(matGray, lines, distance, Math.toRadians(angle), threshold, srn, stn, minTheta, maxTheta);
            //fixme поправить вывод для типа преобразования. Т.к. Матрица линий представленая в классическом содержит 2 или 3 элемента
            // Отрисовка линий
            for (int i = 0; i < lines.rows(); i++) {
                double rho = lines.get(i, 0)[0];
                double theta = lines.get(i, 0)[1];
                double a = Math.cos(theta), b = Math.sin(theta);
                double x0 = a * rho, y0 = b * rho;
                Point pt1 = new Point(Math.round(x0 + 1000 * (-b)), Math.round(y0 + 1000 * (a)));
                Point pt2 = new Point(Math.round(x0 - 1000 * (-b)), Math.round(y0 - 1000 * (a)));
                Imgproc.line(result, pt1, pt2, ImageUtils.COLOR_BLACK, 3, Imgproc.LINE_AA, 0);
            }
        } else {
            Imgproc.HoughLinesP(matGray, lines, distance, Math.toRadians(angle), threshold, minLineLength, maxLineGap);
            for (int i = 0, r = lines.rows(); i < r; i++) {
                for (int j = 0, c = lines.cols(); j < c; j++) {
                    double[] line = lines.get(i, j);
                    Imgproc.line(
                            result,
                            new Point(line[0], line[1]),
                            new Point(line[2], line[3]),
                            ImageUtils.COLOR_BLACK);
                }
            }
        }
        return result;
    }
}
