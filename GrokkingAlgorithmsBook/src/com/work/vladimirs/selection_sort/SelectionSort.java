package com.work.vladimirs.selection_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SelectionSort {

    public <T> List<T> selectionSortASC(List<T> unsortedList, Comparator<T> comparator) {
        List<T> sortedList = new ArrayList<>(unsortedList.size());
        int steps = unsortedList.size();
        for (int i = 0; i < steps; i++) {
            int smallestIndexElem = getSmallestIndexElem(unsortedList, comparator);
            sortedList.add(unsortedList.get(smallestIndexElem));
            unsortedList.remove(smallestIndexElem);
        }
        return sortedList;
    }

    private <T> int getSmallestIndexElem(List<T> unsortedList, Comparator<T> comparator) {
        int smallestIndex = 0;
        T smallest = unsortedList.get(smallestIndex);
        for (int i = 1; i < unsortedList.size(); i++) {
            if (comparator.compare(unsortedList.get(i), smallest) < 0) {
                smallest = unsortedList.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
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

        SelectionSort selectionSort = new SelectionSort();

        List<String> strings = selectionSort.<String>selectionSortASC(stringList, Comparator.comparing(o -> ((String) o)));
        System.out.println(strings);

        List<Integer> integers = selectionSort.<Integer>selectionSortASC(integerList, Comparator.comparing(o -> ((Integer) o)));
        System.out.println(integers);
    }
}
