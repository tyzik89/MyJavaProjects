package com.work.vladimirs.lexicographical_substrings_comparisions;

import java.util.*;

public class LexicographicalCalculator {

    public static void main(String[] args) {
        String result = getSmallestAndLargest("welcometojava", 3);
        System.out.println(result);

    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        HashMap<String, List<String>> dictionary = new HashMap<>();

        String[] charOfString = s.split("");
        StringBuilder builder = new StringBuilder(k);
        for (int i = 0; i < charOfString.length - 1; i++) {
            if ((i + k) <= charOfString.length) {
                builder.append(charOfString[i]);
                for (int j = 1; j < k; j++) {
                    builder.append(charOfString[i + j]);
                }
                dictionary.compute(charOfString[i], (key, value) -> value == null ? new ArrayList<>() : value).add(builder.toString());
                builder.setLength(0);
            }
        }

        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            System.out.printf("Key: %s  Value: %s \n", entry.getKey(), entry.getValue());
        }

        Object[] keys = dictionary.keySet().stream().sorted().toArray();
        List<String> smallestList = dictionary.get(keys[0]);
        List<String> largestList = dictionary.get(keys[keys.length - 1]);

        smallest = smallestList.stream().sorted().findFirst().get();
        largest = largestList.stream().min(Comparator.reverseOrder()).get();

        return smallest + "\n" + largest;
    }
}
