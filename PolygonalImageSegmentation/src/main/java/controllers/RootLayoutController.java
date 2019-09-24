package controllers;

import app.MainApp;
import constants.NotifyConstants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import models.LoaderImages;
import models.Observer;
import models.StorageImages;

public class RootLayoutController implements Observer {

    // Ref on app.MainApp
    private MainApp mainApp;

    //Ref on model class - LoaderImages
    private LoaderImages loaderImages;

    private StorageImages storageImages;

    @FXML
    private ProgressBar prBar;
    @FXML
    private ProgressIndicator prInd;
    @FXML
    private MenuItem itmLoad;
    @FXML
    private MenuItem itmExit;
    @FXML
    private MenuItem itmSourceImage;
    @FXML
    private ImageView imgView;
    @FXML
    private TitledPane commonTools;
    @FXML
    private TitledPane cannyTools;
    @FXML
    private TitledPane hafaTools;
    @FXML
    private Button cancel;
    @FXML
    private Button redo;

    public RootLayoutController() {
        // контролер должен знать модель
        // в модели все вычисления и внутренние данные
        this.loaderImages = new LoaderImages();
        this.storageImages = StorageImages.getInstance();
        //регистрация на сообщения от модели
        loaderImages.registerObserver(this);
    }

    @FXML
    private void initialize() {

    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleItmExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleLoad(ActionEvent event) {
        commonTools.setDisable(false);
        cannyTools.setDisable(false);
        commonTools.setExpanded(true);

        loaderImages.load();
    }

    @Override
    public void notification(String message) {
        if (NotifyConstants.IMAGE_READY.equals(message)) {
            imgView.setImage(storageImages.getCurrentImage());
        }
    }
}
