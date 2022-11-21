package com.vladimirs.work.controllers;

import com.vladimirs.work.models.TextStorage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
public class WordLoadController {

    private final static Logger LOGGER = LoggerFactory.getLogger(WordLoadController.class);

    @FXML
    public Button btnAddWord;
    @FXML
    public Button btnDoExit;
    @FXML
    public TextField itmWordInput;
    @FXML
    public Label errorLabel;

    private Stage addWordStage;
    private TextStorage textStorage;

    @FXML
    public void handleAddWord(ActionEvent actionEvent) {
        CharSequence charSequence = itmWordInput.getCharacters();
        if (charSequence.length() > 0) {
            LOGGER.debug(charSequence.toString());
            textStorage.addWord(charSequence);
            errorLabel.setText("");
            hideStage();
        } else {
            errorLabel.setText("Пожалуйста, введите слово:");
        }
    }

    @FXML
    public void handleExit(ActionEvent actionEvent) {
        hideStage();
    }

    public void showStage() {
        addWordStage.showAndWait();
    }

    public void hideStage() {
        addWordStage.hide();
    }
}
