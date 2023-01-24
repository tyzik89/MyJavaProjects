package com.work.vladimirs.binary_search;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Бинарный поиск (O(log(n)))
 */
public class BinarySearch {

    public <T> int binarySearch(List<T> sortedList, T searchElement, Comparator<T> comparator) {
        int position = -1;
        int lowBound = 0;
        int highBound = sortedList.size() - 1;

        int iteration = 0;
        while (lowBound <= highBound) {
            iteration++;
            int middleIndex = (lowBound + highBound) / 2;
            T guess = sortedList.get(middleIndex);
            if (comparator.compare(searchElement, guess) == 0) {
                position = middleIndex;
                break;
            }
            if (comparator.compare(searchElement, guess) > 0) {
                lowBound = middleIndex + 1;
            } else {
                highBound = middleIndex - 1;
            }
        }
        System.out.println("Count of iteration: " + iteration);
        return position;
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>(){{
            add("A");
            add("B");
            add("C");
            add("D");
            add("E");
        }};
        List<Integer> integerList = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};

        BinarySearch binarySearch = new BinarySearch();

        int result = binarySearch.binarySearch(stringList, "B", Comparator.comparing(o -> ((String) o)));
        System.out.printf("Is 'B' found: %s\n\n", result == -1? "not found": result + " position");

        result = binarySearch.binarySearch(stringList, "F", Comparator.comparing(o -> ((String) o)));
        System.out.printf("Is 'F' found: %s\n\n", result == -1? "not found": result + " position");

        result = binarySearch.binarySearch(integerList, 4, Comparator.comparing(o -> ((Integer) o)));
        System.out.printf("Is '4' found: %s\n\n", result == -1? "not found": result + " position");

        result = binarySearch.binarySearch(integerList, 7, Comparator.comparing(o -> ((Integer) o)));
        System.out.printf("Is '7' found: %s\n\n", result == -1? "not found": result + " position");

        result = binarySearch.binarySearch(Arrays.asList(IntStream.range(0, 127).boxed().toArray(Integer[]::new)), 127, Comparator.comparing(o -> ((Integer) o)));
        System.out.printf("Is '127' found: %s\n\n", result == -1? "not found": result + " position");

        result = binarySearch.binarySearch(Arrays.asList(IntStream.range(0, 127).boxed().toArray(Integer[]::new)), 126, Comparator.comparing(o -> ((Integer) o)));
        System.out.printf("Is '126' found: %s\n\n", result == -1? "not found": result + " position");

        result = binarySearch.binarySearch(Arrays.asList(IntStream.range(0, 255).boxed().toArray(Integer[]::new)), 555, Comparator.comparing(o -> ((Integer) o)));
        System.out.printf("Is '555' found: %s\n\n", result == -1? "not found": result + " position");
    }
}
