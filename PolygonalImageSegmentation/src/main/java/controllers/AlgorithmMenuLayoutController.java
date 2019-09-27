package controllers;

import constants.NotifyConstants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.image.ImagesHandler;
import models.notification.Observer;

import java.util.Objects;

public class AlgorithmMenuLayoutController implements Observer {

    //Ref on model class - ImagesHandler
    private ImagesHandler imagesHandler;

    @FXML
    private TitledPane commonTools;
    @FXML
    private TitledPane cannyTools;
    @FXML
    private TitledPane hafaTools;
    @FXML
    private Slider binarySlider;
    @FXML
    private Label showBinaryThreshold;
    @FXML
    private CheckBox otsu;
    @FXML
    private Slider sizeGaussFilterCommon;
    @FXML
    private Label showSizeGaussFilterCommon;
    @FXML
    private Slider thresholdCanny;
    @FXML
    private Label showThresholdCanny;
    @FXML
    private TextField sizeGaussFilter;

    public AlgorithmMenuLayoutController(ImagesHandler imagesHandler) {
        // контролер должен знать модель
        // в модели все вычисления и внутренние данные
        this.imagesHandler = imagesHandler;
        //Регистрация в качестве наблюдателя сообщений от модели
        imagesHandler.registerObserver(this);
    }

    @FXML
    private void initialize() {
        commonTools.setDisable(true);
        cannyTools.setDisable(true);
        hafaTools.setDisable(true);

        commonTools.setExpanded(false);
        cannyTools.setExpanded(false);
        hafaTools.setExpanded(false);
    }

    @FXML
    private void handleMakeBinary(ActionEvent event){
        imagesHandler.doMakeBinary((int)binarySlider.getValue(), otsu.isSelected());
    }

    @FXML
    private void makeBlur(ActionEvent event) {
        imagesHandler.doMakeBlur((int) sizeGaussFilterCommon.getValue());
    }

    @FXML
    private void selectOtsu(ActionEvent event) {
        if (otsu.isSelected()) {
            binarySlider.setDisable(true);
        } else {
            binarySlider.setDisable(false);
        }
    }

    @FXML
    private void handleApplyCanny(ActionEvent event) {
        String sizeGFString = sizeGaussFilter.getText();
        int sizeGF = 0;
        if (sizeGFString != null || !Objects.equals(sizeGFString, "")) sizeGF = Integer.parseInt(sizeGFString);

        imagesHandler.doCannyEdgeDetection(sizeGF, (int) thresholdCanny.getValue());
    }

    @FXML
    private void changeBinarySlider() {
        showBinaryThreshold.setText(String.valueOf((int) binarySlider.getValue()));
    }

    @FXML
    private void changeSizeGaussFilterCommon() {
        showSizeGaussFilterCommon.setText(String.valueOf((int) sizeGaussFilterCommon.getValue()));
    }

    @FXML
    private void changeThresholdCanny() {
        showThresholdCanny.setText(String.valueOf((int) thresholdCanny.getValue()));
    }

    @FXML
    public void handleApplyHafa(ActionEvent event) {
        imagesHandler.doHafaConversion();
    }

    @Override
    public void notification(String message) {
        switch (message) {
            case NotifyConstants.IMAGE_LOADED: {
                commonTools.setDisable(false);
                cannyTools.setDisable(false);
                cannyTools.setExpanded(true);
                break;
            }
        }
    }
}
