package com.work.vladimirs.controllers;

import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

class CellFactory extends TableCell<Path, Path> {

    public CellFactory(String strDir) {
        super.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Path path = getItem();
                    if (path == null) return;
                    File file = new File(strDir + path.toString());
                    if (file.isDirectory()) {
                        Desktop.getDesktop().open(file);
                    } else if (file.isFile()) {
                        Desktop.getDesktop().open(new File(strDir));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
