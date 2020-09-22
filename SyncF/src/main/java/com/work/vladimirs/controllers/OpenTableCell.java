package com.work.vladimirs.controllers;

import com.work.vladimirs.entities.InfoFile;
import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.File;
import java.io.IOException;

class OpenTableCell extends TableCell<InfoFile, String> {

    public OpenTableCell() {
        super.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    String path = getItem();
                    if (path == null) return;
                    File file = new File(path);
                    if (file.isDirectory()) {
                        Desktop.getDesktop().open(file);
                    } else if (file.isFile()) {
                        Desktop.getDesktop().open(file);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        if (!empty) {
            setText("Открыть");
        }
        super.updateItem(item, empty);
    }
}
