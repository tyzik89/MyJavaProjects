package models.algorithms;

import org.opencv.core.Mat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class WatershedSegmentation implements Algorithm {

    private final static Logger LOGGER = LoggerFactory.getLogger(WatershedSegmentation.class);

    private Mat mask;

    public WatershedSegmentation(Mat mask) {
        this.mask = mask;
    }

    @Override
    public Mat doAlgorithm(Mat frame) {
        LOGGER.debug("Started processing");

        return mask;
    }
}
