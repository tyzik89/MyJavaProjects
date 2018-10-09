package ru.filemanager.events.catalog;

import ru.filemanager.UI;
import ru.filemanager.dialogs.CreateNewFolderJDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class CatalogAddFolderListener implements ActionListener {
    private UI ui;

    public CatalogAddFolderListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ui.getCatalogDirsCache().isEmpty()) {
            String currentPath;
            File newFolder;
            CreateNewFolderJDialog newFolderJDialog = new CreateNewFolderJDialog(ui);

            if(newFolderJDialog.isReady()) {
                currentPath = toFullPath(ui.getCatalogDirsCache());
                newFolder = new File(currentPath, newFolderJDialog.getNewFolderName());
                if (!newFolder.exists())
                    newFolder.mkdir();

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
}
