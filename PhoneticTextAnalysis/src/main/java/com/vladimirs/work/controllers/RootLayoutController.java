package com.vladimirs.work.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RootLayoutController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RootLayoutController.class);

    private Stage primaryStage;
    private WordLoadController controller;

    @FXML
    private MenuItem itmLoad;
    @FXML
    private MenuItem itmExit;

    @FXML
    private void handleItmExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void handleWordLoad(ActionEvent actionEvent) {
        if (controller == null) {
            LOGGER.debug("WordLoadController initialization");
            controller = new WordLoadController();
            controller.init(this);
        }
        controller.showStage();
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
