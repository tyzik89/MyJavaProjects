package com.work.vladimirs.patterns.decorator.example_3.bad_extends_example;

import java.util.Arrays;

class Test {

    public static void main(String[] args) {
        InstrumentalHashSet<String> s = new InstrumentalHashSet<>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));

        // Должно быть 3, а вставляется 6.
        // Т.к. родитель в addAll использует add. Т.е. мы дублируем подсчёт.
        System.out.println(s.getAddCount());
    }
}
