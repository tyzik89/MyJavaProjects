package ru.filemanager.events.catalog;

import ru.filemanager.UI;
import ru.filemanager.dialogs.RenameJDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class CatalogRenameListener implements ActionListener {
    private UI ui;

    public CatalogRenameListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!ui.getCatalogDirsCache().isEmpty() & ui.getCatalogFilesList().getSelectedValue() != null) {
            String currentPath = toFullPath(ui.getCatalogDirsCache());
            String selectedObject = ui.getCatalogFilesList().getSelectedValue().toString();

            RenameJDialog renameJDialog = new RenameJDialog(ui);

            File renameFile = new File(currentPath, selectedObject);
            renameFile.renameTo(new File(currentPath, renameJDialog.getNewName()));

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

    //Вспомогательный метод склейки пути из кусочков, хрянищихся в массиве
    private String toFullPath(ArrayList<String> edges) {
        StringBuilder part = new StringBuilder("");
        for (String edge : edges) {
            part.append(edge);
        }
        return part.toString();
    }
}
