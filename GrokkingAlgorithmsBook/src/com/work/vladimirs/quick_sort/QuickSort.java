package com.work.vladimirs.quick_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuickSort {

    public <T> List<T> quickSortASC(List<T> unsortedList, Comparator<T> comparator) {
        if (unsortedList.size() < 2) {
            return unsortedList;
        }
        T supportElem = unsortedList.get(0);
        List<T> unsortedListLess = new ArrayList<>();
        List<T> unsortedListGreater = new ArrayList<>();
        for (int i = 1; i < unsortedList.size(); i++) {
            T nextElem = unsortedList.get(i);
            if (comparator.compare(supportElem, nextElem) >= 0) {
                unsortedListLess.add(nextElem);
            } else {
                unsortedListGreater.add(nextElem);
            }
        }
        // Рекурсивно сортируем часть массива, которая меньше опорного элемента
        List<T> sortedList = quickSortASC(unsortedListLess, comparator);
        // Добавляем опорный элемент
        sortedList.add(supportElem);
        // Рекурсивно сортируем часть массива, которая больше опорного элемента
        sortedList.addAll(quickSortASC(unsortedListGreater, comparator));
        return sortedList;
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>() {{
            add("C");
            add("D");
            add("E");
            add("A");
            add("B");
        }};
        List<Integer> integerList = new ArrayList<Integer>() {{
            add(4);
            add(3);
            add(2);
            add(1);
            add(5);
        }};

        QuickSort quickSort = new QuickSort();

        List<String> strings = quickSort.<String>quickSortASC(stringList, Comparator.comparing(o -> ((String) o)));
        System.out.println(strings);

        List<Integer> integers = quickSort.<Integer>quickSortASC(integerList, Comparator.comparing(o -> ((Integer) o)));
        System.out.println(integers);
    }
}
