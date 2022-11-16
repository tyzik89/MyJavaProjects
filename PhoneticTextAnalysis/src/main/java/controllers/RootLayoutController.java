package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RootLayoutController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RootLayoutController.class);

    private final FXMLLoader loader = new FXMLLoader();

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
        loader.setLocation(getClass().getResource("/fxml/WordLoadLayout.fxml"));
        try {
            Parent parent = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Анализ слова");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
