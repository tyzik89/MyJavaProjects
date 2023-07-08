package com.work.vladimirs.patterns.decorator.example_3.composition_plus_frowarding_example;

import java.util.Arrays;
import java.util.HashSet;

class Test {

    public static void main(String[] args) {
        InstrumentalHashSet<String> s = new InstrumentalHashSet<>(new HashSet<>());
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));

        // Должно быть 3, и вставляется 3.
        // Всё корректно
        System.out.println(s.getAddCount());
    }
}
