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

    private int distance;
    private int angle;
    private int threshold;

    private int srn;
    private int stn;
    private int minTheta;
    private int maxTheta;

    private int minLineLength;
    private int maxLineGap;

    public HoughConversionAlgorithm(boolean typeHoughMethod, int ... params) {
        this.typeHoughMethodClassic = typeHoughMethod;
        this.distance = params[0];
        this.angle = params[1];
        this.threshold = params[2];

        if (typeHoughMethodClassic) {
            this.srn = params[3];
            this.stn = params[4];
            this.minTheta = params[5];
            this.maxTheta = params[6];
        } else {
            this.minLineLength = params[3];
            this.maxLineGap = params[4];
        }
    }

    @Override
    public Mat doAlgorithm(Mat frame) {
        //Конвертируем изображение в одноканальное
        Mat matGray = new Mat();
        Imgproc.cvtColor(frame, matGray, Imgproc.COLOR_BGR2GRAY);
        //матрица для хранения отрезков
        Mat lines = new Mat();

        if (typeHoughMethodClassic) {
            Imgproc.HoughLines(matGray, lines, distance, Math.toRadians(angle), threshold, srn, stn, minTheta, maxTheta);
        } else {
            Imgproc.HoughLinesP(matGray, lines, distance, Math.toRadians(angle), threshold, minLineLength, maxLineGap);
        }

        Mat result = new Mat(frame.size(), CvType.CV_8UC3, ImageUtils.COLOR_WHITE);
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
        return result;
    }
}
