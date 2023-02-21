package com.work.vladimirs.other.lexicographical_substrings_comparisions;

public class LexicographicalCalculator {

    public static void main(String[] args) {
        String result = getSmallestAndLargest("welcometojava", 3);
        System.out.println(result);

    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        smallest = s.substring(0, k);
        largest = s.substring(0, k);
        for (int i = 1; i < s.length() - 1; i++) {
            k += 1;
            if (k > s.length()) break;
            String temp = s.substring(i, k);
            smallest = smallest.compareTo(temp) > 0 ? temp : smallest;
            largest = largest.compareTo(temp) < 0 ? temp : largest;
        }

        return smallest + "\n" + largest;
    }
}
