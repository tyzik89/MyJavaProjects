package controllers;

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

import javax.annotation.PostConstruct;

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

    public void init() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/WordLoadLayout.fxml"));
            Parent parent = loader.load();
            wordLoadStage = new Stage();
            wordLoadStage.setTitle("Анализ слова");
            wordLoadStage.setScene(new Scene(parent));
            wordLoadStage.setResizable(false);
            wordLoadStage.setMaximized(false);
            wordLoadStage.setAlwaysOnTop(true);
            wordLoadStage.initModality(Modality.APPLICATION_MODAL);
            wordLoadStage.show();
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
            wordLoadStage.hide();
        } else {
            errorLabel.setText("Пожалуйста, введите слово:");
        }
    }

    @FXML
    public void handleExit(ActionEvent actionEvent) {
        wordLoadStage.hide();
    }

    public CharSequence getCharSequence() {
        return charSequence;
    }

    public void setCharSequence(CharSequence charSequence) {
        this.charSequence = charSequence;
    }
}
