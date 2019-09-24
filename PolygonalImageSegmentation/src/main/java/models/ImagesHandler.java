package models;

import constants.NotifyConstants;
import javafx.scene.image.Image;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
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
        Mat mat = Imgcodecs.imread("src/main/resources/img/1.png", Imgcodecs.IMREAD_COLOR);
        Image image = ImageConverterUtils.mat2Image(mat);
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

    public void doMakeBinary() {
        Mat mat = ImageConverterUtils.image2Mat(storageImages.getCurrentImage());
        //Кодирование в одноканальное изображение
        mat = Imgcodecs.imdecode(mat, CvType.CV_8UC1);
        System.out.println(mat.cols());
        //Перевод в бинарное изображение
        Imgproc.threshold(mat, mat, 0, 255, Imgproc.THRESH_BINARY + Imgproc.THRESH_OTSU);
        System.out.println(mat.cols());
        switchImagesOnNextStep(ImageConverterUtils.mat2Image(mat));
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
        storageImages.setPreviousImage(storageImages.getCurrentImage());
        storageImages.setCurrentImage(newImage);
        notifyObservers(NotifyConstants.IMAGE_READY);
    }
}
