package ru.filemanager;

import ru.filemanager.events.ExitListener;
import ru.filemanager.events.catalog.*;
import ru.filemanager.events.image.ImageClearListener;
import ru.filemanager.events.image.ImageLoadListener;
import ru.filemanager.events.image.ImageRunListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class UI extends JFrame {
    //Вкладки
    private JTabbedPane jTabbedPane = new JTabbedPane();

    //*******************************Изображения*********************************************
    private JButton imageLoadButton = new JButton("Загрузить изображение");
    private JButton imageClearButton = new JButton("Очистить");
    private JButton imageRunButton = new JButton("Обработать");
    private JButton imageExitButton = new JButton("Выход");
    private JPanel imageButtonsPanel = new JPanel();
    private JPanel imagesPanel = new JPanel();
    private JLabel imageLabelLeft = new JLabel();
    private JPanel imagePanelLeft = new JPanel();
    private JLabel imageLabelRight = new JLabel();
    private JPanel imagePanelRight = new JPanel();
    private File selectedFile;
    private BufferedImage image = ImageIO.read(new File("src/main/resources/default.jpg"));
    private JRadioButton greyButton = new JRadioButton("Серый", true);
    private JRadioButton waveButton_1 = new JRadioButton("Волны_1", false);
    private JRadioButton waveButton_2 = new JRadioButton("Волны_2", false);
    private JRadioButton maxwellButton = new JRadioButton("Треугольник Максвелла", false);
    private JRadioButton correlationButton = new JRadioButton("Корреляция", false);
    private JRadioButton bordersButton = new JRadioButton("Выделение границ", false);
    ButtonGroup groupRadioButtons = new ButtonGroup();
    //

    //*******************************Проводник*********************************************
    private JPanel catalogPanel = new JPanel();
    private JList catalogFilesList = new JList();
    private JScrollPane catalogFilesScroll = new JScrollPane(catalogFilesList);
    private JPanel catalogButtonsPanel = new JPanel();
    //Buttons
    private JButton catalogAddFolderButton = new JButton("Создать папку");
    private JButton catalogBackButton = new JButton("Назад");
    private JButton catalogDeleteButton = new JButton("Удалить");
    private JButton catalogRenameButton = new JButton("Переименовать");
    private JButton catalogZipButton = new JButton("ZIP");
    private JButton catalogExitButton = new JButton("Выход");
    //Сохранение текущей позиции в каталогах
    private ArrayList<String> catalogDirsCache = new ArrayList<String>();
    //Получаем корневые разделы дисков
    public static final File[] ROOT_DISCS = File.listRoots();

    public UI() throws IOException {
        super("Программа");
        //Остановка приложения при закрытии приложения
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Разрешение менять размер окна
        setResizable(true);
        //Создание макета для панели каталогов
        catalogPanel.setLayout(new BorderLayout(5, 5));
        catalogPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //Создание макета для панели кнопок
        catalogButtonsPanel.setLayout(new GridLayout(2, 4, 5, 5));

        JDialog createNewDirDialog = new JDialog(UI.this, "Создание папки", true);
        JPanel createNewDirPanel = new JPanel();
        createNewDirDialog.add(createNewDirPanel);

        //Задание минимального размера скролла
        catalogFilesScroll.setPreferredSize(new Dimension(400, 500));
        catalogFilesList.setListData(ROOT_DISCS);
        //В открывшемся списке каталогов можно выбирать несколько строк
        catalogFilesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        imagePanelLeft.setLayout(new BorderLayout(5 ,5));
        imagePanelRight.setLayout(new BorderLayout(5, 5));
        imageButtonsPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        imageButtonsPanel.setLayout(new GridLayout(3, 2, 5 , 5));
        imagePanelLeft.add(imageLabelLeft, BorderLayout.WEST);
        imagePanelRight.add(imageLabelRight, BorderLayout.WEST);
        imageButtonsPanel.add(imageLoadButton);
        imageButtonsPanel.add(imageRunButton);
        imageButtonsPanel.add(imageClearButton);
        imageButtonsPanel.add(imageExitButton);
        //imagesPanel.setLayout(new GridLayout(2, 2, 5, 5));
        greyButton.setActionCommand("grey");
        waveButton_1.setActionCommand("wave_1");
        waveButton_2.setActionCommand("wave_2");
        maxwellButton.setActionCommand("maxwell");
        correlationButton.setActionCommand("correlation");
        bordersButton.setActionCommand("borders");
        groupRadioButtons.add(greyButton);
        groupRadioButtons.add(waveButton_1);
        groupRadioButtons.add(waveButton_2);
        groupRadioButtons.add(maxwellButton);
        groupRadioButtons.add(correlationButton);
        groupRadioButtons.add(bordersButton);
        imageButtonsPanel.add(greyButton);
        imageButtonsPanel.add(waveButton_1);
        imageButtonsPanel.add(waveButton_2);
        imageButtonsPanel.add(maxwellButton);
        imageButtonsPanel.add(correlationButton);
        imageButtonsPanel.add(bordersButton);


        imagesPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        /*Эти поля определяют стратегию изменения размеров компонента, отвечая за выделение пространства для столбцов (weightx) и строк (weighty).
        Если записать в них нулевые значения все добавленные компоненты соберутся в центре контейнера и будут выровнены по центру (как по вертикали, так и по горизонтали).
        Чтобы размеры компонента изменялись по горизонтали или вертикали, в поля weightx и weightx нужно записать значения от 0.0 до 1.0.
        Если в столбце несколько компонентов, то его ширина будет определяться компонентом с максимальным значением weightx. Аналогичное утверждение верно и для строк.
        Заметим, что дополнительное пространство добавляется к строкам и столбцам снизу и справа, соответственно.*/
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.NORTHWEST;
        imagesPanel.add(imagePanelLeft, c);

        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.NORTHWEST;
        imagesPanel.add(imagePanelRight, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        /*Поля gridwidth и gridheight определяют количество ячеек, занимаемых добавляемым компонентом.
        Если компонент полностью помещается в одну ячейку, вы можете задать в этих полях значение единицы.
        Если же компонент должен занимать, например, две смежные ячейки в одной строке,
        то для gridwidth нужно задать значение, равное двум, а для gridheight - значение, равное единице. */
        c.gridwidth = 2;
        c.gridheight = 1;
        c.weighty = 0.0;
        c.weightx = 0.0;
        c.anchor = GridBagConstraints.PAGE_END;
        imagesPanel.add(imageButtonsPanel, c);


        catalogButtonsPanel.add(catalogBackButton);
        catalogButtonsPanel.add(catalogAddFolderButton);
        catalogButtonsPanel.add(catalogRenameButton);
        catalogButtonsPanel.add(catalogDeleteButton);
        catalogButtonsPanel.add(catalogZipButton);
        catalogButtonsPanel.add(catalogExitButton);
        catalogPanel.setLayout(new BorderLayout());
        catalogPanel.add(catalogFilesScroll, BorderLayout.CENTER);
        catalogPanel.add(catalogButtonsPanel, BorderLayout.SOUTH);

        jTabbedPane.addTab("Проводник", catalogPanel);
        jTabbedPane.addTab("Изображения", imagesPanel);

        /*ПРОВОДНИК*/
        catalogFilesList.addMouseListener(new CatalogFilesListListener(UI.this));
        catalogBackButton.addActionListener(new CatalogBackListener(UI.this));
        catalogAddFolderButton.addActionListener(new CatalogAddFolderListener(UI.this));
        catalogDeleteButton.addActionListener(new CatalogDeleteListener(UI.this));
        catalogRenameButton.addActionListener(new CatalogRenameListener(UI.this));
        catalogZipButton.addActionListener(new CatalogZipListener(UI.this));

        /*ИЗОБРАЖЕНИЯ*/
        imageRunButton.addActionListener(new ImageRunListener(UI.this));
        imageLoadButton.addActionListener(new ImageLoadListener(UI.this));
        imageClearButton.addActionListener(new ImageClearListener(UI.this));

        /*ВЫХОД*/
        catalogExitButton.addActionListener(new ExitListener());
        imageExitButton.addActionListener(new ExitListener());

        //Получаем панель контента и добавляем в неё все созданные ренее элементы
        getContentPane().add(jTabbedPane);
        setSize(600, 600);
        //pack();
        //Окно открывается по середине
        setLocationRelativeTo(null);
        //Отображение всех элементов
        setVisible(true);
    }


    /*ГЕТТЕРЫ и СЕТТЕРЫ*/

    public ButtonGroup getGroupRadioButtons() {
        return groupRadioButtons;
    }

    public JList getCatalogFilesList() {
        return catalogFilesList;
    }

    public void setCatalogFilesList(JList catalogFilesList) {
        this.catalogFilesList = catalogFilesList;
    }

    public ArrayList<String> getCatalogDirsCache() {
        return catalogDirsCache;
    }

    public void setCatalogDirsCache(ArrayList<String> catalogDirsCache) {
        this.catalogDirsCache = catalogDirsCache;
    }

    public JLabel getImageLabelRight() {
        return imageLabelRight;
    }

    public void setImageLabelRight(JLabel imageLabelRight) {
        this.imageLabelRight = imageLabelRight;
    }

    public JLabel getImageLabelLeft() {
        return imageLabelLeft;
    }

    public void setImageLabelLeft(JLabel imageLabelLeft) {
        this.imageLabelLeft = imageLabelLeft;
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
