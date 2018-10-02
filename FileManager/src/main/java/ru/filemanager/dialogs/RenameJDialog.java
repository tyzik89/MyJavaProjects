package ru.filemanager.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RenameJDialog extends JDialog {
    private JTextField nameOfNewFolder = new JTextField(10);
    private JButton renameButton = new JButton("Переименовать");
    private JButton cancelButton = new JButton("Отмена");
    private JLabel nameFolderWait = new JLabel("Новое имя: ");
    private boolean ready = false;
    private String newFolderName;

    public RenameJDialog(JFrame jFrame) {
        super(jFrame, "Переименовать", true);
        setLayout(new GridLayout(2, 2, 5, 5));
        setSize(400, 200);

        renameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFolderName = nameOfNewFolder.getText();
                setVisible(false);
                ready = true;
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ready = false;
            }
        });

        getContentPane().add(nameFolderWait);
        getContentPane().add(nameOfNewFolder);
        getContentPane().add(renameButton);
        getContentPane().add(cancelButton);

        pack();
        //Окно открывается по середине
        setLocationRelativeTo(null);
        //Отображение всех элементов
        setVisible(true);

    }


    public String getNewName() {
        return newFolderName;
    }

    public boolean isReady() {
        return ready;
    }

    public void Waiting() {
        while (!ready) {

        }
    }
}
