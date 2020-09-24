package com.work.vladimirs.controllers;

import com.work.vladimirs.entities.InfoFile;
import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
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
        super.updateItem(item, empty);

        if (!empty) {
            String path = getItem();
            if (path == null) return;
            setGraphic(null);
            TableRow<InfoFile> currentRow = getTableRow();
            File file = new File(path);
            if (file.isDirectory()) {
                setText("Папка");
                currentRow.setStyle("-fx-background-color:#f1f4b2");
            } else if (file.isFile()) {
                setText("Файл");
                currentRow.setStyle("-fx-background-color:lightcoral");
            }
        }
    }
}
