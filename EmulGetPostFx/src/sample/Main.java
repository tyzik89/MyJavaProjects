package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// JavaFX приложения наследуют класс javafx.application.Application
public class Main extends Application {

    private int windowWidth = 376;
    private int windowHeight = 456;

    // чтобы создать JavaFX приложения, достаточно реализовать метод start(Stage)
    // Stage - это контейнер, ассоциированный с окном
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Если вы загляните в файл sample.fxml, то у видете в нем XML объявление элемента Pane, т.е. контейнера
        // Этот контейнер мы будем считать корневым, т.е. все элементы нашего приложения будут содержаться в нем
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("EmulGetPost");
        primaryStage.setScene(new Scene(root, windowWidth, windowHeight));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
