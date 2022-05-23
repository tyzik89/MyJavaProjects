package com.work.vladimirs.patterns.iterator.menu_implementation;

import com.work.vladimirs.patterns.iterator.iterators_implemantation.DinerMenuIterator;
import com.work.vladimirs.patterns.iterator.iterators_implemantation.Iterator;

public class DinerMenu {

    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private final MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT",
                "(Fakin’) Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT",
                "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false, 3.05);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can’t add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    /**
     * Метод возвращает интерфейс Iterator. Клиенту
     * не нужно знать ни то, как коллекция menuItems
     * хранится в DinerMenu, ни то, как реализован
     * DinerMenuIterator. Клиент просто использует
     * итератор для перебора элементов.
     *
     * @return объект DinerMenuIterator для массива menuItems и возвращает его клиенту.
     */
    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}
