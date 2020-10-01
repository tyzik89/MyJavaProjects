package com.work.vladimirs;

import com.work.vladimirs.controllers.RootLayoutController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLClassLoader;

public class SyncF extends Application {
    private static final String ICO_TRAY_ICON = "ico/tray-icon.png";
    private Stage stage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;

        // Приложение не завершается при закрытии окна приложения "крестиком"
        Platform.setImplicitExit(false);
        // Настройка в трее (испльзуем awt в swing потоке).
        javax.swing.SwingUtilities.invokeLater(this::addAppToTray);

        primaryStage.setTitle("com.work.vladimirs.SyncF");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setWidth(1024);
        primaryStage.setHeight(768);

        initRootLayout(primaryStage);

        primaryStage.show();

        /*primaryStage.setOnCloseRequest(windowEvent -> {
            Platform.exit();
            System.exit(0);
        });*/
    }

    private void initRootLayout(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootLayout.fxml"));
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

            RootLayoutController rootLayoutController = loader.getController();
            rootLayoutController.setStage(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Сворачивание приложения в трей
     */
    private void addAppToTray() {
        try {
            // Инициализация инструментов awt
            java.awt.Toolkit.getDefaultToolkit();

            // Прилжению нужна беспечение поддержки трея, если не пддерживается, то просто выходим
            if (!java.awt.SystemTray.isSupported()) {
                System.out.println("No system tray support, application exiting.");
                Platform.exit();
            }

            // Устанавливаем иконку в системный трей
            java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();
            /*URL imageLoc = new URL(
                    ICO_TRAY_ICON
            );*/

            //Загружаем иконку
            ClassLoader cl = this.getClass().getClassLoader();
           // URLClassLoader urlLoader=(URLClassLoader)this.getClass().getClassLoader();
            InputStream is =  cl.getResourceAsStream(ICO_TRAY_ICON);
            java.awt.Image image = ImageIO.read(is);
            // isn't working in JAR
            //java.awt.Image image = ImageIO.read(new File(cl.getResource(ICO_TRAY_ICON).getFile()));
            java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(image);

            // При двойным клике на иконку в трее разворачивается наше приложение
            trayIcon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            SyncF.this.showStage();
                        }
                    });
                }
            });

            java.awt.MenuItem settingsItem = new java.awt.MenuItem("Настройки");
            settingsItem.addActionListener(event -> Platform.runLater(this::showStage));
            java.awt.Font defaultFont = java.awt.Font.decode(null);
            java.awt.Font boldFont = defaultFont.deriveFont(java.awt.Font.BOLD);
            settingsItem.setFont(boldFont);

            // to really exit the application, the user must go to the system tray icon
            // and select the exit option, this will shutdown JavaFX and remove the
            // tray icon (removing the tray icon will also shut down AWT).
            java.awt.MenuItem exitItem = new java.awt.MenuItem("Выход");
            exitItem.addActionListener(event -> {
                tray.remove(trayIcon);
                Platform.exit();
            });

            // setup the popup menu for the application.
            final java.awt.PopupMenu popup = new java.awt.PopupMenu();
            popup.add(settingsItem);
            popup.addSeparator();
            popup.add(exitItem);
            trayIcon.setPopupMenu(popup);

            // add the application tray icon to the system tray.
            tray.add(trayIcon);
        } catch (java.awt.AWTException | IOException e) {
            System.out.println("Unable to init system tray");
            e.printStackTrace();
        }
    }

    /**
     * Показывает окно приложения и обеспечивается его показ поверх остальных окон.
     */
    private void showStage() {
        if (stage != null) {
            stage.show();
            stage.toFront();
        }
    }
}
