package ru.filemanager.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteJDialog extends JDialog {

    private JPanel buttonsPanel = new JPanel();
    JButton okButton = new JButton("Да");
    JButton cancelButton = new JButton("Нет");
    private JLabel question = new JLabel("Вы точно хотите удалить это?");
    private boolean isOk = false;

    public DeleteJDialog(JFrame jFrame) {
        super(jFrame, "Подтверждение удаления",  true);
        setLayout(new GridLayout(2, 2, 5, 5));
        setSize(400, 200);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                isOk = true;
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                isOk = false;
            }
        });

        buttonsPanel.add(okButton);
        buttonsPanel.add(cancelButton);
        getContentPane().add(question);
        getContentPane().add(buttonsPanel);
        pack();
        //Окно открывается по середине
        setLocationRelativeTo(null);
        //Отображение всех элементов
        setVisible(true);

    }

    public boolean isOk() {
        return isOk;
    }
}
