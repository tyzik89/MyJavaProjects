package com.work.vladimirs.other.anagram;

class Result {
    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        // Две строки разной длины не могут быть анаграммами друг друга.
        if (s.length() % 2 != 0) return -1;

        String s1 = s.substring(0, (s.length()/2));
        String s2 = s.substring((s.length()/2));

        for (int i = 0; i < s1.length(); i++) {
            String ch = String.valueOf(s1.charAt(i));
            if (s2.contains(ch)) {
                s2 = s2.replaceFirst(ch, "");
            }
        }

        return s2.length();
    }
}
