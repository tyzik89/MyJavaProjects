package com.work.vladimirs.controllers;

import com.work.vladimirs.algorithms.PathsWorker;
import com.work.vladimirs.algorithms.SetOperations;
import com.work.vladimirs.entities.InfoFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private PathsWorker pathsWorker = new PathsWorker();


    public TextField txtField_1;
    String strField_1;
    public TextField txtField_2;
    String strField_2;
    @FXML
    private Button chooseBtn_1;
    @FXML
    private Button chooseBtn_2;
    public Button btnClear_1;
    public Button btnClear_2;


    public TableView<InfoFile> tblViewPaths_1;
    public TableColumn<InfoFile, Path> tblColumnPath_1;
    public TableColumn<InfoFile, Long> tblColumnSize_1;
    public TableColumn<InfoFile, String> tblColumnRef_1;

    public TableView<InfoFile> tblViewPaths_2;
    public TableColumn<InfoFile, Path> tblColumnPath_2;
    public TableColumn<InfoFile, Long> tblColumnSize_2;
    public TableColumn<InfoFile, String> tblColumnRef_2;


    public Button btnSwitchMode;
    public Button btnAnalyze;
    public Button btnSync;
    public Button btnClear;

    private ObservableList<InfoFile> observableRowsPath_1 = FXCollections.observableArrayList();
    private ObservableList<InfoFile> observableRowsPath_2 = FXCollections.observableArrayList();

    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void initialize () {
        //Кнопка синхронизации не активна
        btnSync.setDisable(true);
        //Установка первоначального режима работы
        mode = Mode.REMOTE_TO_LOCAL;
        setImageOnBtnSwitch(mode.getImageAndSetMode());

        //Первоначальная инициализация колонок таблицы #1
        tblColumnPath_1.setCellValueFactory(new PropertyValueFactory<InfoFile, Path>("shortPath"));
        tblColumnSize_1.setCellValueFactory(new PropertyValueFactory<InfoFile, Long>("size"));
        tblColumnRef_1.setCellValueFactory(new PropertyValueFactory<InfoFile, String>("fullPath"));
        tblColumnRef_1.setCellFactory(param -> new OpenTableCell());      //Открытие папки с файлами по клику
        tblViewPaths_1.setItems(observableRowsPath_1);                    //Привязка к таблице #1 наблюдаемого списка значений

        //Первоначальная инициализация колонок таблицы #2
        tblColumnPath_2.setCellValueFactory(new PropertyValueFactory<InfoFile, Path>("shortPath"));
        tblColumnSize_2.setCellValueFactory(new PropertyValueFactory<InfoFile, Long>("size"));
        tblColumnRef_2.setCellValueFactory(new PropertyValueFactory<InfoFile, String>("fullPath"));
        tblColumnRef_2.setCellFactory(param -> new OpenTableCell());      //Открытие папки с файлами по клику
        tblViewPaths_2.setItems(observableRowsPath_2);                    //Привязка к таблице #2 наблюдаемого списка значений

    }

    @FXML
    public void clickBtnSync(ActionEvent event) {
        if (Mode.REMOTE_TO_LOCAL.equals(mode)) {
            if (!observableRowsPath_2.isEmpty()) {
                pathsWorker.syncFiles(observableRowsPath_2, strField_1);
            }
        } else if (Mode.LOCAL_TO_REMOTE.equals(mode)) {
            if (!observableRowsPath_1.isEmpty()) {
                pathsWorker.syncFiles(observableRowsPath_1, strField_2);
            }
        } else if (Mode.MUTUAL.equals(mode)) {
            pathsWorker.syncFiles(observableRowsPath_2, strField_1);
            pathsWorker.syncFiles(observableRowsPath_1, strField_2);
        }
        btnSync.setDisable(true);
    }

    @FXML
    public void clickBtnAnalyze(ActionEvent event) {
        clearTablesData();
        strField_1 = txtField_1.getCharacters().toString();
        strField_2 = txtField_2.getCharacters().toString();
        if (!strField_1.isEmpty() && !strField_2.isEmpty()) {
            try {
                TreeSet<InfoFile> pathSet_1 = pathsWorker.analyzeDir(strField_1);
                TreeSet<InfoFile> pathSet_2 = pathsWorker.analyzeDir(strField_2);

                if (Mode.REMOTE_TO_LOCAL.equals(mode)) {
                    observableRowsPath_2.addAll(SetOperations.difference(pathSet_2, pathSet_1));
                    tblViewPaths_2.setItems(observableRowsPath_2);

                } else if (Mode.LOCAL_TO_REMOTE.equals(mode)) {
                    observableRowsPath_1.addAll(SetOperations.difference(pathSet_1, pathSet_2));

                } else if (Mode.MUTUAL.equals(mode)) {
                    observableRowsPath_1.addAll(SetOperations.difference(pathSet_1, pathSet_2));
                    tblViewPaths_1.setItems(observableRowsPath_1);
                    observableRowsPath_2.addAll(SetOperations.difference(pathSet_2, pathSet_1));
                    tblViewPaths_2.setItems(observableRowsPath_2);
                }

                if ( !(observableRowsPath_1.isEmpty() && observableRowsPath_2.isEmpty()) )
                    btnSync.setDisable(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void clickChooseBtn_1(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Выбрать директорию для синхронизации");
        File selectedDirectory = directoryChooser.showDialog(primaryStage.getScene().getWindow());
        if (selectedDirectory != null) {
            String absPath = selectedDirectory.getAbsolutePath();
            if (!absPath.isEmpty() && !absPath.equals(txtField_1.getText())) {
                txtField_1.setText(absPath);
                btnSync.setDisable(true);
            }
        }
    }

    @FXML
    private void clickChooseBtn_2(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Выбрать директорию для синхронизации");
        File selectedDirectory = directoryChooser.showDialog(primaryStage.getScene().getWindow());
        if (selectedDirectory != null) {
            String absPath = selectedDirectory.getAbsolutePath();
            if (!absPath.isEmpty() && !absPath.equals(txtField_2.getText())) {
                txtField_2.setText(absPath);
                btnSync.setDisable(true);
            }
        }
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
        clearTablesData();
        btnSync.setDisable(true);
    }

    private void clearTablesData() {
        tblViewPaths_1.getItems().clear();
        tblViewPaths_2.getItems().clear();
        tblViewPaths_1.refresh();
        tblViewPaths_2.refresh();
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
        btnSync.setDisable(true);
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
}
