package com.vladimirs.work.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.util.Random;

@Getter
@Setter
public class RootLayoutController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RootLayoutController.class);

    @FXML
    public LineChart<String, Number> itmLineChart;
    @FXML
    public MenuItem itmAnalyze;
    @FXML
    private MenuItem itmAddWord;
    @FXML
    private MenuItem itmExit;

    private Stage primaryStage;
    private ObservableList<CharSequence> charSequenceObservableList = FXCollections.observableArrayList();

    @FXML
    private void handleItmExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void handleAddWord(ActionEvent actionEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        showAddWordWindow(stringBuilder);
        charSequenceObservableList.add(stringBuilder);
    }

    private void showAddWordWindow(StringBuilder stringBuilder) {
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
            controller.setStringBuilder(stringBuilder);
            addWordStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleItmAnalyze(ActionEvent actionEvent) {
        int j = 0;
        LOGGER.debug(charSequenceObservableList.toString());
        itmLineChart.getData().clear();
        Random random = new Random();
        for (CharSequence charSequence : charSequenceObservableList) {
            XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
            series.setName(charSequence.toString());
            for (int i = 0; i < charSequence.length(); i++) {
                j++;
                char ch = charSequence.charAt(i);
                series.getData().add(new XYChart.Data<String, Number>(j+"-"+ch, random.nextInt(6) + 1));
            }
            itmLineChart.getData().add(series);
        }

//                XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
//        series.setName("мама");
//        series.getData().add(new XYChart.Data<String, Number>("1-м", 6));
//        series.getData().add(new XYChart.Data<String, Number>("2-а", 10));
//        series.getData().add(new XYChart.Data<String, Number>("3-м", 6));
//        series.getData().add(new XYChart.Data<String, Number>("4-а", 10));
//        itmLineChart.getData().add(series);
//
//        XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
//        series1.setName("правда");
//        series1.getData().add(new XYChart.Data<String, Number>("1-п", 2));
//        series1.getData().add(new XYChart.Data<String, Number>("2-р", 7));
//        series1.getData().add(new XYChart.Data<String, Number>("3-а", 10));
//        series1.getData().add(new XYChart.Data<String, Number>("4-в", 3));
//        series1.getData().add(new XYChart.Data<String, Number>("5-д", 5));
//        series1.getData().add(new XYChart.Data<String, Number>("6-а", 10));
//        itmLineChart.getData().add(series1);
    }
}
