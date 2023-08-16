package com.work.vladimirs.annotations.simple_test_annotation;

public class Sample {

    // Тест должен быть пройден
    @Test
    public static void ml() {

    }

    public static void m2() {

    }

    // Тест не должен быть пройден
    @Test
    public static void m3() {
        throw new RuntimeException("Boom") ;
    }

    // НЕВЕРНОЕ ИСПОЛЬЗОВАНИЕ:
    // нестатический метод
    @Test
    public void m5() {

    }

    public static void m6() {

    }

    // Тест не должен быть пройден
    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {

    }
}
