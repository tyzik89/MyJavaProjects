package com.work.vladimirs.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Задача о рюкзаке.
 * Есть набор предметов, которые можно унести в рюкзаке.
 * Необходимо набрать максимальное количество дорогих предметов
 * Общий вес рюкзака - 4 кг
 * Магнитофон - стоимость 3000$, вес 4 кг
 * Ноутбук - стоимость 2000$, вес 3 кг
 * Гитара - стоимость 1500$, вес 1 кг
 *
 * + доп. предметы Телефон и Плеер
 */
public class DynamicProgramming {

    private static final Integer BACKPACK_CAPACITY = 4;

    public static void main(String[] args) {
        List<Item> items = new ArrayList<Item>() {{
            add(new Item("Гитара", 1500, 1));
            add(new Item("Магнитофон", 3000, 4));
            add(new Item("Ноутбук", 2000, 3));
//            add(new Item("Телефон", 2000, 1));
//            add(new Item("Плеер", 1000, 1));
        }};

        // Создаём таблицу рюкзаков с лежащими внутри предметами, различной ёмкости ( от 1 до BACKPACK_CAPACITY)
        // и количеством равным BACKPACK_CAPACITY
        Item[][] backpacks = new Item[items.size()][BACKPACK_CAPACITY];

        // бежим по столбцам (ячейкам с предметами)
        for (int i = 0; i < backpacks.length; i++) {
            // бежим по строкам (рюкзакам различной ёмкости)
            for (int j = 0; j < backpacks[i].length; j++) {
                backpacks[i][j] = fillCellMaxPriceItem(backpacks, i, j, items.get(i));
            }
        }

        printResult(backpacks);
    }

    private static void printResult(Item[][] backpacks) {
        for (int i = 0; i < backpacks.length; i++) {
            for (int j = 0; j < backpacks[i].length; j++) {
                System.out.println(backpacks[i][j] + " | ");
            }
            System.out.println("=================================================");
        }
        int rows = backpacks.length - 1;
        int cols = backpacks[rows].length - 1;
        System.out.println("Итого в рюкзаке: " + backpacks[rows][cols]);
    }

    private static Item fillCellMaxPriceItem(Item[][] backpacks, int i, int j, Item currentItem) {
        // Ёмкость текущего рюкзака
        Integer currentCapacity = j + 1;
        // Проверка того, что мы только начали
        if (i == 0) {
            // Если текущий предмет влезает в рюкзак, помещаем его туда
            if (currentItem.weight <= currentCapacity) {
                return currentItem;
            } else {
                // Иначе в рюкзан запихнуть нечего
                return null;
            }
        } else {
            // Предыдущий максимум
            Item previousItemMaxPrice = backpacks[i - 1][j]; // Ячейка предыдущей строки того же столбца таблицы
            Item newCalculatedItem = getNewCalculatedItem(backpacks, i, j, currentItem, currentCapacity);
            if (newCalculatedItem == null) {
                return previousItemMaxPrice;
            }
            if (previousItemMaxPrice == null) {
                return newCalculatedItem;
            }
            return previousItemMaxPrice.price >= newCalculatedItem.price ? previousItemMaxPrice : newCalculatedItem;
        }

    }

    private static Item getNewCalculatedItem(Item[][] backpacks, int i, int j, Item currentItem, Integer currentCapacity) {
        // Если вес текущего предмета не входит в рюкзак
        if (currentItem.weight > currentCapacity) {
            return null;
        }
        // Если вес текущего предмета точно входит в рюкзак
        if (currentItem.weight.equals(currentCapacity)) {
            return currentItem;
        }
        // Если вес текущего предмета входит в рюкзак + осталось место
        // Берём на свободное место вычесленный ранее предмет
        Item itemForFreeSpace = backpacks[i - 1][j - currentItem.weight];
        if (itemForFreeSpace != null) {
            // Объединяем предменты и запихиваем в рюкзак
            return unionItems(currentItem, itemForFreeSpace);
        }
        return currentItem;
    }

    private static Item unionItems(Item i1, Item i2) {
        return new Item(
                i1.name.concat(" ").concat(i2.name),
                i1.price + i2.price,
                i1.weight + i2.weight);
    }

    static class Item {
        String name;
        Integer price;
        Integer weight;

        public Item(String name, Integer price, Integer weight) {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", weight=" + weight +
                    '}';
        }
    }
}
