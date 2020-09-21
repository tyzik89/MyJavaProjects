package com.work.vladimirs.controllers;

import com.work.vladimirs.AnalyzeSyncPathes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.TreeSet;

public class RootLayoutController {
    private Stage primaryStage;
    private Mode mode;
    private enum Mode{
        REMOTE_TO_LOCAL {
            public String getImageAndSetMode() {return "src/main/resources/ico/2.png";}
        },

        LOCAL_TO_REMOTE {
            public String getImageAndSetMode() {return "src/main/resources/ico/3.png";}
        },

        MUTUAL {
            public String getImageAndSetMode() {return "src/main/resources/ico/1.png";}
        };

        public abstract String getImageAndSetMode();
    }

    public TextField txtField_1;
    public TextField txtField_2;
    @FXML
    private Button chooseBtn_1;
    @FXML
    private Button chooseBtn_2;
    public Button btnClear_1;
    public Button btnClear_2;

    public TextArea txtArea_1;
    public TextArea txtArea_2;

    public Button btnSwitchMode;
    public Button btnAnalyze;
    public Button btnSync;
    public Button btnClear;

    @FXML
    private void initialize () {
        mode = Mode.REMOTE_TO_LOCAL;
        setImageOnBtnSwitch(mode.getImageAndSetMode());
    }

    private void setImageOnBtnSwitch(String mode) {
        File file = new File(mode);
        Image imageOk = null;
        try {
            imageOk = new Image(file.toURI().toURL().toString(), 50, 50, false, true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        btnSwitchMode.graphicProperty().setValue(new ImageView(imageOk));
    }

    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void clickChooseBtn_1(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Выбрать директорию для синхронизации");
        File selectedDirectory = directoryChooser.showDialog(primaryStage.getScene().getWindow());
        if (selectedDirectory != null)
            txtField_1.setText(selectedDirectory.getAbsolutePath());
    }

    @FXML
    private void clickChooseBtn_2(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Выбрать директорию для синхронизации");
        File selectedDirectory = directoryChooser.showDialog(primaryStage.getScene().getWindow());
        if (selectedDirectory != null)
            txtField_2.setText(selectedDirectory.getAbsolutePath());
    }

    @FXML
    public void clickBtnClear_1(ActionEvent event) {
        txtField_1.clear();
    }

    @FXML
    public void clickBtnClear_2(ActionEvent event) {
        txtField_2.clear();
    }

    @FXML
    public void clickBtnClear(ActionEvent event) {
        txtArea_1.clear();
        txtArea_2.clear();
    }

    @FXML
    public void clickBtnAnalyze(ActionEvent event) {
        String strField_1 = txtField_1.getCharacters().toString();
        if (strField_1 != null && !strField_1.isEmpty()) {
            txtArea_1.clear();
            try {
                TreeSet<Path> pathSet_1 = AnalyzeSyncPathes.analyzeDir(strField_1);
                for (Path path : pathSet_1) {
                    txtArea_1.appendText(path.toString());
                    txtArea_1.appendText("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void clickBtnSync(ActionEvent event) {
    }

    @FXML
    public void clickBtnSwitchMode(ActionEvent event) {
        switch (mode) {
            case REMOTE_TO_LOCAL:
                mode = Mode.LOCAL_TO_REMOTE;
                break;
            case LOCAL_TO_REMOTE:
                mode = Mode.MUTUAL;
                break;
            case MUTUAL:
                mode = Mode.REMOTE_TO_LOCAL;
                break;
        }
        setImageOnBtnSwitch(mode.getImageAndSetMode());
    }
}
