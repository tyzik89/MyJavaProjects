package com.vladimirs.work.controllers;

import com.vladimirs.work.models.TextHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordLoadController {

    private final static Logger LOGGER = LoggerFactory.getLogger(WordLoadController.class);

    private static Stage wordLoadStage;

    private CharSequence charSequence;

    @FXML
    public Button btnLoad;
    @FXML
    public Button itmExit;
    @FXML
    public TextField itmWordInput;
    @FXML
    public Label errorLabel;

    public void init(RootLayoutController rootLayoutController) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/WordLoadLayout.fxml"));
            Parent parent = loader.load();
            wordLoadStage = new Stage();
            wordLoadStage.setTitle("Анализ слова");
            wordLoadStage.setScene(new Scene(parent));
            wordLoadStage.setResizable(false);
            wordLoadStage.setMaximized(false);
            wordLoadStage.setAlwaysOnTop(true);
            wordLoadStage.initOwner(rootLayoutController.getPrimaryStage());
            wordLoadStage.initModality(Modality.WINDOW_MODAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleAnalyze(ActionEvent actionEvent) {
        CharSequence charSequence = itmWordInput.getCharacters();
        if (charSequence.length() > 0) {
            LOGGER.debug(charSequence.toString());
            errorLabel.setText("");
            this.charSequence = charSequence;
            TextHandler textHandler = new TextHandler();
            textHandler.handle(charSequence);
            hideStage();
        } else {
            errorLabel.setText("Пожалуйста, введите слово:");
        }
    }

    @FXML
    public void handleExit(ActionEvent actionEvent) {
        hideStage();
    }

    public CharSequence getCharSequence() {
        return charSequence;
    }

    public void setCharSequence(CharSequence charSequence) {
        this.charSequence = charSequence;
    }

    public void showStage() {
        wordLoadStage.show();
    }

    public void hideStage() {
        wordLoadStage.hide();
    }
}
