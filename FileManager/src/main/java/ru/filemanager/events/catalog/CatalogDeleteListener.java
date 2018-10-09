package ru.filemanager.events.catalog;

import ru.filemanager.UI;
import ru.filemanager.dialogs.DeleteJDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class CatalogDeleteListener implements ActionListener {
    private UI ui;

    public CatalogDeleteListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedObject = ui.getCatalogFilesList().getSelectedValue().toString();
        String currentPath = toFullPath(ui.getCatalogDirsCache());
        if(!selectedObject.isEmpty()) {
            DeleteJDialog deleteJDialog = new DeleteJDialog(ui);
            if(deleteJDialog.isOk()) {

                deleteDir(new File(currentPath, selectedObject));

                File updateDir = new File(currentPath);
                String updateMass[] = updateDir.list();
                DefaultListModel updateModel = new DefaultListModel();
                for (String mass : updateMass) {
                    File check = new File(updateDir.getPath(), mass);
                    if (!check.isHidden()) {
                        if (check.isDirectory())
                            updateModel.addElement(mass);
                        else
                            updateModel.addElement("Файл - " + mass);
                    }
                }
                ui.getCatalogFilesList().setModel(updateModel);
            }
        }
    }

    //Вспомогательный метод склейки пути из кусочков, хрянищихся в массиве
    private String toFullPath(ArrayList<String> edges) {
        StringBuilder part = new StringBuilder("");
        for (String edge : edges) {
            part.append(edge);
        }
        return part.toString();
    }

    //Вспомогательный рекурсивный метод для удаления директорий(и поддерикторий, если они есть)
    private void deleteDir(File file) {
        File[] objects = file.listFiles();
        if (objects != null) {
            for (File f : objects) {
                deleteDir(f);
            }
        }
        file.delete();
    }
}
