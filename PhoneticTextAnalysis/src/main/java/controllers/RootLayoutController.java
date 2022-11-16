package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RootLayoutController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RootLayoutController.class);

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
        WordLoadController controller = new WordLoadController();
        controller.init();
    }
}
