package models.image;

import constants.NotifyConstants;
import javafx.scene.image.Image;
import models.algorithms.CannyEdgeDetectorAlgorithm;
import models.algorithms.GaussBlurAlgorithm;
import models.notification.Observable;
import models.notification.Observer;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import utils.ImageConverterUtils;

import java.util.LinkedList;
import java.util.List;

public class ImagesHandler implements Observable {

    private StorageImages storageImages;
    private List<Observer> observers;

    public ImagesHandler() {
        this.storageImages = StorageImages.getInstance();
        this.observers = new LinkedList<>();
    }

    public void load() {
        //fixme исправить загрузку изображения
        // An image file on the hard drive.
        /*File file = new File("C:/MyImages/myphoto.jpg");
        // --> file:/C:/MyImages/myphoto.jpg
        String localUrl = file.toURI().toURL().toString();
        Image image = new Image(localUrl);*/
        Mat mat = Imgcodecs.imread("src/main/resources/img/1.png", Imgcodecs.IMREAD_UNCHANGED);
        Image image = ImageConverterUtils.matToImageFX(mat);
        storageImages.init(image);

        notifyObservers(NotifyConstants.IMAGE_READY);
    }

    /**
     * Отмена алгоритма, т.е. возврат предыдущего состояния объекта Image
     * Возврат алгоритма, т.е. возврат обработанного состояния объекта Image
     */
    public void doCancelRedo() {
        Image temp = storageImages.getCurrentImage();
        storageImages.setCurrentImage(storageImages.getPreviousImage());
        storageImages.setPreviousImage(temp);
        notifyObservers(NotifyConstants.IMAGE_READY);
    }

    public void doMakeBinary(int threshold, boolean isOtsu) {
        Mat mat = ImageConverterUtils.imageFXToMat(storageImages.getCurrentImage());
        Mat mat_gray = new Mat();
        //Конвертируем изображение в одноканальное
        Imgproc.cvtColor(mat, mat_gray, Imgproc.COLOR_BGR2GRAY);
        //Перевод в бинарное изображение
        Mat mat_binary = new Mat();
        if (isOtsu) {
            Imgproc.threshold(mat_gray, mat_binary, 0, 255, Imgproc.THRESH_BINARY + Imgproc.THRESH_OTSU);
        } else {
            Imgproc.threshold(mat_gray, mat_binary, threshold, 255, Imgproc.THRESH_BINARY);
        }
        switchImagesOnNextStep(ImageConverterUtils.matToImageFX(mat_binary));
    }

    public void doCannyEdgeDetection(int sizeGaussFilter, int threshold) {
        Mat mat = ImageConverterUtils.imageFXToMat(storageImages.getCurrentImage());
        CannyEdgeDetectorAlgorithm cannyEdgeDetectorAlgorithm = new CannyEdgeDetectorAlgorithm(sizeGaussFilter, threshold);
        Mat result = cannyEdgeDetectorAlgorithm.doAlgorithm(mat);
        switchImagesOnNextStep(ImageConverterUtils.matToImageFX(result));
    }

    public void doMakeBlur(int sizeGaussFilter) {
        Mat mat = ImageConverterUtils.imageFXToMat(storageImages.getCurrentImage());
        GaussBlurAlgorithm gaussBlurAlgorithm = new GaussBlurAlgorithm(sizeGaussFilter);
        Mat result = gaussBlurAlgorithm.doAlgorithm(mat);
        switchImagesOnNextStep(ImageConverterUtils.matToImageFX(result));
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.notification(message);
        }
    }

    public Image getCurrentImage() {
        return storageImages.getCurrentImage();
    }

    private void switchImagesOnNextStep(Image newImage) {
        storageImages.switchImagesOnNextStep(newImage);
        notifyObservers(NotifyConstants.IMAGE_READY);
    }
}
