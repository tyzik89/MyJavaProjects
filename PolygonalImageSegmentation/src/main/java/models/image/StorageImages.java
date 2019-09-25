package models.image;

import javafx.scene.image.Image;

public class StorageImages {

    private static Image SourceImage;
    private static Image CurrentImage;
    private static Image PreviousImage;

    private static StorageImages INSTANCE = new StorageImages();

    private StorageImages(){}

    public static StorageImages getInstance()
    {
        return INSTANCE;
    }


    public void init(Image image) {
        SourceImage = image;
        CurrentImage = image;
        PreviousImage = image;
    }

    public void switchImagesOnNextStep(Image newImage) {
        PreviousImage = CurrentImage;
        CurrentImage = newImage;
    }

    public Image getSourceImage() {
        return SourceImage;
    }

    public void setSourceImage(Image sourceImage) {
        SourceImage = sourceImage;
    }

    public Image getCurrentImage() {
        return CurrentImage;
    }

    public void setCurrentImage(Image currentImage) {
        CurrentImage = currentImage;
    }

    public Image getPreviousImage() {
        return PreviousImage;
    }

    public void setPreviousImage(Image previousImage) {
        PreviousImage = previousImage;
    }
}
