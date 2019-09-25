package models.algorithms;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class GaussBlurAlgorithm {

    private int sizeGaussFilter;

    public GaussBlurAlgorithm(int sizeGaussFilter) {
        this.sizeGaussFilter = sizeGaussFilter;
    }

    public Mat doAlgorithm(Mat mat) {
        if (sizeGaussFilter > 0)
            Imgproc.blur(mat, mat, new Size(sizeGaussFilter, sizeGaussFilter));
        return mat;
    }
}
