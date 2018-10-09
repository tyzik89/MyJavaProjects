package ru.filemanager.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateNewFolderJDialog extends JDialog {
    private JTextField nameOfNewFolder = new JTextField(10);
    private JButton createButton = new JButton("Создать");
    private JButton cancelButton = new JButton("Отмена");
    private JLabel nameFolderWait = new JLabel("Имя новой папки: ");
    private String newFolderName;
    private boolean ready = false;

    public CreateNewFolderJDialog(JFrame jFrame) {
        super(jFrame, "Создать новую папку", true);
        setLayout(new GridLayout(2, 2, 5, 5));
        setSize(400, 200);

        createButton.addActionListener(new ActionListener() {
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
        getContentPane().add(createButton);
        getContentPane().add(cancelButton);

        pack();
        //Окно открывается по середине
        setLocationRelativeTo(null);
        //Отображение всех элементов
        setVisible(true);
    }

    public String getNewFolderName() {
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
