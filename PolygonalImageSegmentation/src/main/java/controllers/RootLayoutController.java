package controllers;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import utils.ImageConverterUtils;

public class RootLayoutController {

    // Ref on app.MainApp
    private MainApp mainApp;

    @FXML
    private ProgressBar prBar;
    @FXML
    private ProgressIndicator prInd;
    @FXML
    private MenuItem itmOpen;
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
    private void handleOpen(ActionEvent event) {
        commonTools.setDisable(false);
        cannyTools.setDisable(false);
        commonTools.setExpanded(true);


        Mat mat = Imgcodecs.imread("src/main/resources/img/1.png", Imgcodecs.IMREAD_GRAYSCALE);
        //Перевод в бинарное изображение
        Imgproc.threshold(mat, mat, 0, 255, Imgproc.THRESH_BINARY + Imgproc.THRESH_OTSU);

        imgView.setImage(ImageConverterUtils.mat2Image(mat));
    }
}
