package com.vladimirs.work.controllers;

import com.vladimirs.work.models.CharacterLevel;
import com.vladimirs.work.models.TextHandler;
import com.vladimirs.work.models.TextStorage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Getter
@Setter
public class RootLayoutController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RootLayoutController.class);

    @FXML
    public LineChart<String, Number> itmLineChart;
    @FXML
    public MenuItem itmAnalyze;
    @FXML
    public MenuItem itmClear;
    @FXML
    private MenuItem itmAddWord;
    @FXML
    private MenuItem itmExit;

    private final TextStorage textStorage;
    private final TextHandler textHandler;
    private Stage primaryStage;

    public RootLayoutController() {
        this.textStorage = new TextStorage();
        this.textHandler = new TextHandler();
    }

    @FXML
    private void handleItmExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void handleAddWord(ActionEvent actionEvent) {
        showAddWordWindow(textStorage);
    }

    private void showAddWordWindow(TextStorage textStorage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/WordLoadLayout.fxml"));
            Parent parent = loader.load();
            Stage addWordStage = new Stage();
            addWordStage.setTitle("Добавление слова");
            addWordStage.initModality(Modality.WINDOW_MODAL);
            addWordStage.initOwner(primaryStage);
            addWordStage.setScene(new Scene(parent));
            WordLoadController controller = loader.getController();
            controller.setAddWordStage(addWordStage);
            controller.setTextStorage(textStorage);
            controller.showStage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleItmAnalyze(ActionEvent actionEvent) {
        int serialNum = 0;
        itmLineChart.getData().clear();

        for (CharSequence charSequence : textStorage.getCharSequenceObservableList()) {
            XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
            series.setName(charSequence.toString());
            List<CharacterLevel> characterLevels = textHandler.handleCharSequence(charSequence);
            for (CharacterLevel chLevel : characterLevels) {
                serialNum++;
                series.getData().add(new XYChart.Data<String, Number>(serialNum+"-"+chLevel.getCharacter(), chLevel.getPhoneticLevel()));
            }
            itmLineChart.getData().add(series);
        }
    }

    @FXML
    public void handleItmClear(ActionEvent actionEvent) {
        itmLineChart.getData().clear();
        textStorage.clearStorage();
    }
}
