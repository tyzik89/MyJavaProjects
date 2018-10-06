package ru.filemanager.events.catalog;

import ru.filemanager.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class CatalogBackListener implements ActionListener {
    private UI ui;

    public CatalogBackListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ui.getCatalogDirsCache().size() > 1) {
            ui.getCatalogDirsCache().remove(ui.getCatalogDirsCache().size() - 1);
            //Получаем путь до текущей папки
            String backDir = toFullPath(ui.getCatalogDirsCache());
            //Получаем список объектов до текущего каталога
            String[] rootStr = new File(backDir).list();
            //Создаём модель
            DefaultListModel backRootModel = new DefaultListModel();

            for (String s : rootStr) {
                File checkFile = new File(backDir, s);
                if (!checkFile.isHidden()) {
                    if (checkFile.isDirectory()) {
                        backRootModel.addElement(s);
                    } else {
                        backRootModel.addElement("Файл - " + s);
                    }
                }
            }
            ui.getCatalogFilesList().setModel(backRootModel);
        } else {
            ui.getCatalogDirsCache().removeAll(ui.getCatalogDirsCache());
            ui.getCatalogFilesList().setListData(ui.ROOT_DISCS);
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
