package models.algorithms;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 * Алгоритм Кэнни по обнаружению границ состоит из четырём этапов:
 * 1) Размытие по Гауссу, для очистки любых пятен и шумов на изображении.
 * 2) Оператор градиента применяется, для получения интенсивности и направления градиента.
 * 3) Определение факта что пиксель является лучшим кандитатом на ребро, чем его соседи.
 * 4) Hysteresis thresholding находит где края начинаются и заканчиваются.
 */
public class CannyEdgeDetectorAlgorithm {

    private int sizeGaussFilter;
    private int threshold;
    private boolean needToUseL2Gradient = false;
    private int apertureSize = 3;

    public CannyEdgeDetectorAlgorithm(int sizeGaussFilter, int threshold) {
        this.sizeGaussFilter = sizeGaussFilter;
        this.threshold = threshold;
    }

    public CannyEdgeDetectorAlgorithm(int sizeGaussFilter, int threshold, boolean needToUseL2Gradient) {
        this(sizeGaussFilter, threshold);
        this.needToUseL2Gradient = needToUseL2Gradient;
    }

    public CannyEdgeDetectorAlgorithm(int sizeGaussFilter, int threshold, int apertureSize) {
        this(sizeGaussFilter, threshold);
        this.apertureSize = apertureSize;
    }

    public CannyEdgeDetectorAlgorithm(int sizeGaussFilter, int threshold, int apertureSize, boolean needToUseL2Gradient) {
        this(sizeGaussFilter, threshold);
        this.apertureSize = apertureSize;
        this.needToUseL2Gradient = needToUseL2Gradient;
    }

    public Mat doAlgorithm(Mat mat) {
        //Конвертируем изображение в одноканальное
        Mat mat_gray = new Mat();
        Imgproc.cvtColor(mat, mat_gray, Imgproc.COLOR_BGR2GRAY);

        //Применяем размытие по Гауссу
        Mat mat_detected_edges = new Mat();
        GaussBlurAlgorithm gaussBlurAlgorithm = new GaussBlurAlgorithm(sizeGaussFilter);
        mat_detected_edges = gaussBlurAlgorithm.doAlgorithm(mat_gray);

        /*detectedEdges: Входное изображение, полутоновое
          detectedEdges: Выходная матрица
          threshold: Значение порога, заданное пользователем
          threshold * 3: Установка трёхкратного нижнего порога (following Canny’s recommendation)
          apertureSize(3): Размер ядра Собеля для внутреннего использования
          needToUseL2Gradient(false): флаг, указывающий на возможность использования более точного расчёта  величины градиента.*/

        Imgproc.Canny(mat_detected_edges, mat_detected_edges, threshold,threshold * 3, apertureSize, needToUseL2Gradient);

        //Создаём матрицу и заполняем её нулями. Получаем совершенно чёрное изображение
        Mat dest = new Mat();
        Core.add(dest, Scalar.all(0), dest);

        //Копируем только те зоны, которые идентифицированы как отрезки (на чёрном фоне)
        mat.copyTo(dest, mat_detected_edges);

        return mat_detected_edges;
    }
}
