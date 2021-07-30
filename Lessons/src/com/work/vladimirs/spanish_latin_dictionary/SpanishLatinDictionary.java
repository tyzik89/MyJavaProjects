package com.work.vladimirs.spanish_latin_dictionary;

import java.util.*;

public class SpanishLatinDictionary {

    public static void main(String[] args) {
        SortedMap<String, TreeSet<String>> latinDictionary = new TreeMap<String, TreeSet<String>>();
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();  // Дочитываем строку полностью, т.к. nextInt() считывает только до символа новой строки

        for (int i = 0; i < count; i++) {
            String str = scanner.nextLine();
            deserializeStringAndFillMap(str, latinDictionary);
        }
        formatPrintMap(latinDictionary);
    }

    private static void deserializeStringAndFillMap(String str, SortedMap<String, TreeSet<String>> latinDictionary) {
        String spanish = str.split(" - ")[0]; //Первый элемент массива - испонаское слово
        String[] latin = str.split(" - ")[1].split(", "); //Второй элемент массива - массив латинских слов

        for (String latinWord : latin) {
            TreeSet<String> treeSetSpanish = latinDictionary.get(latinWord);
            if (treeSetSpanish == null) {
                treeSetSpanish = new TreeSet<String>();
            }
            treeSetSpanish.add(spanish);
            latinDictionary.put(latinWord, treeSetSpanish);
        }
    }

    private static void formatPrintMap(SortedMap<String, TreeSet<String>> latinDictionary) {
        StringBuilder builder = new StringBuilder();
        builder.append(latinDictionary.size()).append("\n");
        for (Map.Entry<String, TreeSet<String>> stringTreeSetEntry : latinDictionary.entrySet()) {
           builder.append(stringTreeSetEntry.getKey()).append(" - ");
            TreeSet<String> treeSetSpanish = stringTreeSetEntry.getValue();
            for (String setSpanish : treeSetSpanish) {
                builder.append(setSpanish).append(", ");
            }
            builder.replace(builder.length()-2, builder.length(), "\n");//Удаляем последние два символа запятую и пробел
        }
        System.out.print(builder);
    }
}
