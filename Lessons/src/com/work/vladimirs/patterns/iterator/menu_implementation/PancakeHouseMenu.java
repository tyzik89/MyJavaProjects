package com.work.vladimirs.patterns.iterator.menu_implementation;

import com.work.vladimirs.patterns.iterator.iterators_implemantation.Iterator;
import com.work.vladimirs.patterns.iterator.iterators_implemantation.PancakeHouseMenuIterator;

import java.util.ArrayList;
import java.util.List;

public class PancakeHouseMenu {

    private List<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<MenuItem>();
        addItem("K&B’s Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true,
                2.99);
        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);
        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49);
        addItem("Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return (ArrayList<MenuItem>) menuItems;
    }

    /**
     * Метод возвращает интерфейс Iterator. Клиенту
     * не нужно знать ни то, как коллекция menuItems
     * хранится в PancakeHouseMenu, ни то, как реализован
     * PancakeHouseMenuIterator. Клиент просто использует
     * итератор для перебора элементов.
     *
     * @return объект PancakeHouseMenuIterator для массива menuItems и возвращает его клиенту.
     */
    public Iterator createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }
}
