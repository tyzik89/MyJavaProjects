package models;

import constants.NotifyConstants;
import javafx.scene.image.Image;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import utils.ImageConverterUtils;

import java.util.LinkedList;
import java.util.List;

public class LoaderImages implements Observable {

    private StorageImages storageImages;
    private List<Observer> observers;

    public LoaderImages() {
        this.storageImages = StorageImages.getInstance();
        this.observers = new LinkedList<>();
    }

    public void load() {
        //fixme исправить загрузку изображения
        Mat mat = Imgcodecs.imread("src/main/resources/img/1.png", Imgcodecs.IMREAD_GRAYSCALE);
        //Перевод в бинарное изображение
        //Imgproc.threshold(mat, mat, 0, 255, Imgproc.THRESH_BINARY + Imgproc.THRESH_OTSU);
        Image image = ImageConverterUtils.mat2Image(mat);
        storageImages.init(image);
        notifyObservers(NotifyConstants.IMAGE_READY);
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
}
