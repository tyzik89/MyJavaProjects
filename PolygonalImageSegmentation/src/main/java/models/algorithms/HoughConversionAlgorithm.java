package models.algorithms;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
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

    private int distance;
    private int angle;
    private int threshold;

    private int srn;
    private int stn;
    private int minTheta;
    private int maxTheta;

    private int minLineLength;
    private int maxLineGap;

    public HoughConversionAlgorithm(int ... params) {
        this.distance = params[0];
        this.angle = params[1];
        this.threshold = params[2];
    }

    @Override
    public Mat doAlgorithm(Mat frame) {
        //Конвертируем изображение в одноканальное
        Mat matGray = new Mat();
        Imgproc.cvtColor(frame, matGray, Imgproc.COLOR_BGR2GRAY);
        //матрица для хранения отрезков
        Mat lines = new Mat();

        Imgproc.HoughLinesP(matGray, lines, distance, Math.toRadians(angle), threshold);

        Mat result = new Mat(frame.size(), CvType.CV_8UC3, ImageUtils.COLOR_WHITE);
        //fixme доделать
        return lines;
    }
}
