package app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Phonetic Analysis");
        initRootLayout(primaryStage);
        primaryStage.setOnCloseRequest(windowEvent -> {
            Platform.exit();
            System.exit(0);
        });
    }

    /**
     * Инициализация корневого макета.
     */
    private void initRootLayout(Stage primaryStage) {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/RootLayout.fxml"));
            // Загружаем интерфейс из файл
            Parent rootLayout = loader.load();
            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            //primaryStage.setMaximized(true);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
