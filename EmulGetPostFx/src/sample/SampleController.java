package sample;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.UnsupportedEncodingException;

public class SampleController {

    @FXML
    private Button cancel;

    @FXML
    private Button run;

    @FXML
    private TextField url;

    @FXML
    private TextArea params;

    @FXML
    private ChoiceBox<String> type;

    @FXML
    private TextArea responce;

    @FXML
    private ProgressBar process;

    @FXML
    public void initialize(){
        ObservableList<String> methods = FXCollections.observableArrayList("POST", "GET");
        type.setItems(methods);
        type.setValue("POST");

        url.setText("http://httpbin.org/post");
    }

    @FXML
    public void runMethod() {
        process.setProgress(0.0);
        HttpConnection connection = new HttpConnection(type.getValue(), url.getText(), params.getText());
        String str = connection.doRequest();
        responce.setText(str);
        process.setProgress(1.0);
    }

    @FXML
    public void cancelMethod() {
        Platform.exit();
    }
    /*
    //Либо отмену можно сделать через обработчик, не привязывая к fxml
    @FXML
    public void initialize(){
        cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> Platform.exit());
    }*/
}
