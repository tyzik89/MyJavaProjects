package ru.filemanager;

import ru.filemanager.dialogs.CreateNewFolderJDialog;
import ru.filemanager.dialogs.DeleteJDialog;
import ru.filemanager.dialogs.RenameJDialog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class UI extends JFrame {

    private JTabbedPane jTabbedPane = new JTabbedPane();

    //Изображения
    private JButton loadImageButton = new JButton("Загрузить изображение");
    private JButton clearButton = new JButton("Очистить");
    //private JButton exitButton = new JButton("Выход");
    private JButton runButton = new JButton("Обработать");
    private JPanel buttonsImagesPanel = new JPanel();
    //private ImagePanel imagePanel  = new ImagePanel("C:\\ideaProject\\lesson\\src\\ru\\image\\1.jpeg");
    private JPanel imagesPanel = new JPanel();
    private JLabel imageLabelLeft = new JLabel();
    private JPanel imagePanelLeft = new JPanel();
    private JLabel imageLabelRight = new JLabel();
    private JPanel imagePanelRight = new JPanel();
    private File selectedFile;
    private BufferedImage image;

    //Проводник
    private JPanel catalogPanel = new JPanel();
    private JList filesList = new JList();
    private JScrollPane filesScroll = new JScrollPane(filesList);
    private JPanel buttonsPanel = new JPanel();
    //Buttons
    private JButton addFolderButton = new JButton("Создать папку");
    private JButton backButton = new JButton("Назад");
    private JButton deleteButton = new JButton("Удалить");
    private JButton renameButton = new JButton("Переименовать");
    private JButton zipButton = new JButton("ZIP");
    private JButton exitButton = new JButton("Выход");
    //Сохранение текущей позиции в каталогах
    private ArrayList<String> dirsCache = new ArrayList<String>();

    public UI() {
        super("Программа");
        //Остановка приложения при закрытии приложения
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Разрешение менять размер окна
        setResizable(true);
        //Создание макета для панели каталогов
        catalogPanel.setLayout(new BorderLayout(5, 5));
        catalogPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //Создание макета для панели кнопок
        buttonsPanel.setLayout(new GridLayout(2, 4, 5, 5));

        JDialog createNewDirDialog = new JDialog(UI.this, "Создание папки", true);
        JPanel createNewDirPanel = new JPanel();
        createNewDirDialog.add(createNewDirPanel);

        final File[] discs = File.listRoots();
        //Задание минимального размера скролла
        filesScroll.setPreferredSize(new Dimension(400, 500));
        filesList.setListData(discs);
        //В открывшемся списке каталогов можно выбирать несколько строк
        filesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        imagePanelLeft.setLayout(new BorderLayout(5 ,5));
        imagePanelRight.setLayout(new BorderLayout(5, 5));
        buttonsImagesPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        buttonsImagesPanel.setLayout(new GridLayout(4, 1, 5 , 5));
        imagePanelLeft.add(imageLabelLeft, BorderLayout.WEST);
        imagePanelRight.add(imageLabelRight, BorderLayout.WEST);
        buttonsImagesPanel.add(loadImageButton);
        buttonsImagesPanel.add(runButton);
        buttonsImagesPanel.add(clearButton);
        buttonsImagesPanel.add(exitButton);
        imagesPanel.setLayout(new GridLayout(1, 3, 5, 5));
        imagesPanel.add(imagePanelLeft);
        imagesPanel.add(buttonsImagesPanel);
        imagesPanel.add(imagePanelRight);


        buttonsPanel.add(backButton);
        buttonsPanel.add(addFolderButton);
        buttonsPanel.add(renameButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(zipButton);
        buttonsPanel.add(exitButton);
        catalogPanel.setLayout(new BorderLayout());
        catalogPanel.add(filesScroll, BorderLayout.CENTER);
        catalogPanel.add(buttonsPanel, BorderLayout.SOUTH);

        jTabbedPane.addTab("Проводник", catalogPanel);
        jTabbedPane.addTab("Изображения", imagesPanel);
        //Получаем панель контента и добавляем в неё все созданные ренее элементы
        getContentPane().add(jTabbedPane);
        setSize(600, 600);
        //pack();
        //Окно открывается по середине
        setLocationRelativeTo(null);
        //Отображение всех элементов
        setVisible(true);

        //Добавление листенеров на элементы
        //Добавление слушателя на список
        filesList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    DefaultListModel model = new DefaultListModel();
                    String selectedObject = filesList.getSelectedValue().toString();
                    //Для склейки полного пути используем функцию toFullPath
                    String fullPath = toFullPath(dirsCache);
                    File selectedFile;
                    //Проверка, находимся ли мы в начале пути
                    if (dirsCache.size() > 1) {
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
                        dirsCache.add(selectedObject);
                        //На лист добавляем модель с отобранными элементами
                        filesList.setModel(model);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) { }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) { }
        });

        //Слушатель на кнопку назад
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dirsCache.size() > 1) {
                    dirsCache.remove(dirsCache.size() - 1);
                    //Получаем путь до текущей папки
                    String backDir = toFullPath(dirsCache);
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
                    filesList.setModel(backRootModel);
                } else {
                    dirsCache.removeAll(dirsCache);
                    filesList.setListData(discs);
                }
            }
        });

        //Слушатель на кнопку добавить папку
        addFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dirsCache.isEmpty()) {
                    String currentPath;
                    File newFolder;
                    CreateNewFolderJDialog newFolderJDialog = new CreateNewFolderJDialog(UI.this);

                    if(newFolderJDialog.isReady()) {
                        currentPath = toFullPath(dirsCache);
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
                        filesList.setModel(updateModel);
                    }
                }
            }
        });

        //Слушатель на кнопку удалить
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedObject = filesList.getSelectedValue().toString();
                String currentPath = toFullPath(dirsCache);
                if(!selectedObject.isEmpty()) {
                    DeleteJDialog deleteJDialog = new DeleteJDialog(UI.this);
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
                        filesList.setModel(updateModel);
                    }
                }
            }
        });

        //Слушатель на кнопку переименовать
        renameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!dirsCache.isEmpty() & filesList.getSelectedValue() != null) {
                    String currentPath = toFullPath(dirsCache);
                    String selectedObject = filesList.getSelectedValue().toString();

                    RenameJDialog renameJDialog = new RenameJDialog(UI.this);

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
                    filesList.setModel(updateModel);
                }
            }
        });

        //Слушатель на кнопку выход
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        zipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        /*ИЗОБРАЖЕНИЯ*/
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image != null) {
                    //АЛГОРИТМ
                    imageLabelRight.setIcon(new ImageIcon(image));
                }
            }
        });

        loadImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setDialogTitle("Выберите изображение: ");
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = jFileChooser.showOpenDialog(UI.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = new File(jFileChooser.getSelectedFile().getAbsolutePath());
                }
                try {
                    image = ImageIO.read(selectedFile);
                    /*Image dimg = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(dimg));*/
                    imageLabelLeft.setIcon(new ImageIcon(image));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageLabelLeft.setIcon(new ImageIcon(""));
                imageLabelRight.setIcon(new ImageIcon(""));
            }
        });
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
