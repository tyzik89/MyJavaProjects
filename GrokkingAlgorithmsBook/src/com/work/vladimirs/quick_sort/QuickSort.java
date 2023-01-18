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
}
