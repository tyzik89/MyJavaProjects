package controllers;

import app.MainApp;
import constants.NotifyConstants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import models.image.ImagesHandler;
import models.notification.Observer;

public class RootLayoutController implements Observer {

    // Ref on app.MainApp
    private MainApp mainApp;
    //Ref on model class - ImagesHandler
    private ImagesHandler imagesHandler;

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
    @FXML
    private Button makeBinary;
    @FXML
    private Slider binarySlider;
    @FXML
    private CheckBox otsu;

    public RootLayoutController() {
        // контролер должен знать модель
        // в модели все вычисления и внутренние данные
        this.imagesHandler = new ImagesHandler();
        //регистрация на сообщения от модели
        imagesHandler.registerObserver(this);
    }

    @FXML
    private void initialize() {
        commonTools.setDisable(true);
        cannyTools.setDisable(true);
        hafaTools.setDisable(true);
        cancel.setDisable(true);
        redo.setDisable(true);
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
        commonTools.setExpanded(true);

        cannyTools.setDisable(false);

        hafaTools.setDisable(true);
        hafaTools.setExpanded(false);

        imagesHandler.load();
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        imagesHandler.doCancelRedo();
        cancel.setDisable(true);
        redo.setDisable(false);
    }

    @FXML
    private void handleRedo(ActionEvent event) {
        imagesHandler.doCancelRedo();
        redo.setDisable(true);
        cancel.setDisable(false);
    }

    @FXML
    private void handleMakeBinary(ActionEvent event){
        imagesHandler.doMakeBinary((int)binarySlider.getValue(), otsu.isSelected());
    }

    @Override
    public void notification(String message) {
        if (NotifyConstants.IMAGE_READY.equals(message)) {
            imgView.setImage(imagesHandler.getCurrentImage());
            cancel.setDisable(false);
            redo.setDisable(true);
        }
    }

    @FXML
    private void selectOtsu(ActionEvent event) {
        if (otsu.isSelected()) {
            binarySlider.setDisable(true);
        } else {
            binarySlider.setDisable(false);
        }
    }
}
