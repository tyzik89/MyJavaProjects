package controllers;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

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
    private Accordion accordion;
    @FXML
    private TitledPane commonTools;

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
        accordion.setDisable(false);
        commonTools.setExpanded(true);
    }
}
