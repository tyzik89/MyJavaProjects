package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordLoadController {

    private final static Logger LOGGER = LoggerFactory.getLogger(WordLoadController.class);

    @FXML
    public Button btnLoad;
    @FXML
    public Button itmExit;
    @FXML
    public TextField itmWordInput;

    @FXML
    public void handleAnalyze(ActionEvent actionEvent) {

    }

    @FXML
    public void handleExit(ActionEvent actionEvent) {

    }
}
