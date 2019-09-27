package controllers;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import models.image.ImagesHandler;

import java.io.IOException;

/**
 * Главный контроллер
 * Содержит главное меню
 * Инициализирует остальные слои
 * Имеет доступ к главному приложению для подгрузки дополнительных слоёв на главную сцену {@link javafx.stage.Stage}
 */
public class RootLayoutController {

    // Ref on app.MainApp
    private MainApp mainApp;
    //Ref on model class - ImagesHandler
    private ImagesHandler imagesHandler;


    @FXML
    private MenuItem itmLoad;
    @FXML
    private MenuItem itmExit;
    @FXML
    private MenuItem itmSourceImage;


    public RootLayoutController() {
        // контролер должен знать модель
        // в модели все вычисления и внутренние данные
        this.imagesHandler = new ImagesHandler();
    }

    @FXML
    private void initialize () {

    }

    public void initializeOtherElements() {
        // Загрузчик макетов из fxml файла.
        FXMLLoader loader = new FXMLLoader();
        //Загружаем слой, отображающий изображение
        loader.setLocation(MainApp.class.getResource("/fxml/ImageViewLayout.fxml"));
        loader.setControllerFactory(clazz -> {
            if (clazz == ImageViewLayoutController.class) {
                return new ImageViewLayoutController(imagesHandler);
            } else {
                // default behavior:
                try {
                    return clazz.newInstance();
                } catch (Exception exc) {
                    throw new RuntimeException(exc);
                }
            }
        });
        try {
            Parent parent = loader.load();
            mainApp.getRootLayout().setLeft(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Загрузчик макетов из fxml файла.
        loader = new FXMLLoader();
        //Загружаем слой, отображающий нижнюю панель с прогресбаром и кнопками отмены/возврата
        loader.setLocation(MainApp.class.getResource("/fxml/BottomBarLayout.fxml"));
        loader.setControllerFactory(clazz -> {
            if (clazz == BottomBarLayoutController.class) {
                return new BottomBarLayoutController(imagesHandler);
            } else {
                // default behavior:
                try {
                    return clazz.newInstance();
                } catch (Exception exc) {
                    throw new RuntimeException(exc);
                }
            }
        });
        try {
            Parent parent = loader.load();
            mainApp.getRootLayout().setBottom(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Загрузчик макетов из fxml файла.
        loader = new FXMLLoader();
        //Загружаем слой, отображающий панель с алгоритмами
        loader.setLocation(MainApp.class.getResource("/fxml/AlgorithmMenuLayout.fxml"));
        loader.setControllerFactory(clazz -> {
            if (clazz == AlgorithmMenuLayoutController.class) {
                return new AlgorithmMenuLayoutController(imagesHandler);
            } else {
                // default behavior:
                try {
                    return clazz.newInstance();
                } catch (Exception exc) {
                    throw new RuntimeException(exc);
                }
            }
        });
        try {
            Parent parent = loader.load();
            mainApp.getRootLayout().setRight(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleItmExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleLoad(ActionEvent event) {
        imagesHandler.load();
    }



}
