package models;

import javafx.scene.image.Image;

public class StorageImages {

    private Image SourceImage;
    private Image CurrentImage;
    private Image PreviousImage;

    private static StorageImages INSTANCE = new StorageImages();

    private StorageImages(){}

    public static StorageImages getInstance()
    {
        return INSTANCE;
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
