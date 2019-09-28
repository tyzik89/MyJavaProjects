package controllers;

import constants.NotifyConstants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
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
    private TitledPane houghTools;
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
    @FXML
    private CheckBox gradientL2;
    @FXML
    private TextField sizeSobelKernel;
    @FXML
    private ToggleGroup toggleGroupHough;
    @FXML
    private RadioButton radiobHoughProbably;
    @FXML
    private RadioButton radiobHoughClassic;
    @FXML
    private TitledPane titledPaneHoughProbably;
    @FXML
    private TitledPane titledPaneHoughClassic;

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
        houghTools.setDisable(true);

        commonTools.setExpanded(false);
        cannyTools.setExpanded(false);
        houghTools.setExpanded(false);
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
        //Извлечения размера фильтра Гаусса
        String sizeGFString = sizeGaussFilter.getText();
        int sizeGF = 0;
        if (sizeGFString != null || !Objects.equals(sizeGFString, "")) sizeGF = Integer.parseInt(sizeGFString);

        //Извлечение значений ядра Собеля
        String sizeSKString = sizeSobelKernel.getText();
        int sizeSK = 0;
        if (sizeSKString != null || !Objects.equals(sizeSKString, "")) sizeSK = Integer.parseInt(sizeSKString);

        //Нужно ли использовать L2 градиент
        boolean gL2 = gradientL2.isSelected();

        imagesHandler.doCannyEdgeDetection(sizeGF, (int) thresholdCanny.getValue(), sizeSK, gL2);
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
    public void handleApplyHough(ActionEvent event) {
        imagesHandler.doHoughConversion();
    }

    @FXML
    private void changeRadioButtonHoughClassic(ActionEvent event) {
        //RadioButton button = (RadioButton) toggleGroupHough.getSelectedToggle();
        radiobHoughClassic.setSelected(true);
        titledPaneHoughClassic.setDisable(false);
        titledPaneHoughClassic.setExpanded(true);

        radiobHoughProbably.setSelected(false);
        titledPaneHoughProbably.setDisable(true);
        titledPaneHoughProbably.setExpanded(false);
    }

    @FXML
    private void changeRadioButtonHoughProbably(ActionEvent event) {
        radiobHoughProbably.setSelected(true);
        titledPaneHoughProbably.setDisable(false);
        titledPaneHoughProbably.setExpanded(true);

        radiobHoughClassic.setSelected(false);
        titledPaneHoughClassic.setDisable(true);
        titledPaneHoughClassic.setExpanded(false);
    }

    @Override
    public void notification(String message) {
        switch (message) {
            case NotifyConstants.IMAGE_LOADED: {
                commonTools.setDisable(false);
                cannyTools.setDisable(false);
                cannyTools.setExpanded(true);
                houghTools.setDisable(false);
                break;
            }
        }
    }
}
