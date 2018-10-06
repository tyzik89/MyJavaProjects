package ru.filemanager.events.catalog;

import ru.filemanager.UI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

public class CatalogFilesListListener implements MouseListener {
    private UI ui;

    public CatalogFilesListListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            DefaultListModel model = new DefaultListModel();
            String selectedObject = ui.getCatalogFilesList().getSelectedValue().toString();
            //Для склейки полного пути используем функцию toFullPath
            String fullPath = toFullPath(ui.getCatalogDirsCache());
            File selectedFile;
            //Проверка, находимся ли мы в начале пути
            if (ui.getCatalogDirsCache().size() > 1) {
                selectedFile = new File(fullPath, selectedObject);
            } else {
                selectedFile = new File(fullPath + selectedObject);
            }

            if (selectedFile.isDirectory()) {
                //Если директория, то закидываем в массив всё что в каталоге, в который мы зашли
                String[] rootStr = selectedFile.list();
                for (String s : rootStr) {
                    File checkObject = new File(selectedFile.getPath(), s);
                    if (!checkObject.isHidden()) {
                        if (checkObject.isDirectory()) {
                            model.addElement(s);
                        } else {
                            model.addElement("Файл - " + s);
                        }
                    }
                }
                ui.getCatalogDirsCache().add(selectedObject);
                //На лист добавляем модель с отобранными элементами
                ui.getCatalogFilesList().setModel(model);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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
