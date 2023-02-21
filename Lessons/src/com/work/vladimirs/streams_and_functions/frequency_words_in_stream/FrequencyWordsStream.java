package com.work.vladimirs.streams_and_functions.frequency_words_in_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyWordsStream {

    public static void main(String[] args) {
        //Получаем строку, приводим к нижему регистру, разбиваем строку по не символьно-числовы элементам
        Stream<String> stream = Arrays.stream(new Scanner(System.in, "UTF-8").nextLine().toLowerCase().split("[^0-9a-zA-Zа-яА-Я]+"));
//        stream.forEach(System.out::println);

        //Создаём коллекцию слов с количеством их встречаний
        Map<String, Long> map = stream.collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        //Каждую запись сравниваем сначала по частоте появления, по убыванию, а затем по самому слово в лексографическом порядке
        //Ограничиваем количество в 10 и выводим только слово
        map.entrySet().stream().sorted(
                Comparator
                        .comparing((Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue)
                        .reversed()
                        .thenComparing((Map.Entry<String, Long> stringLongEntry) -> stringLongEntry.getKey())
        ).limit(10).forEach(x -> System.out.println(x.getKey()));
    }
}
