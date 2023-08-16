package com.work.vladimirs.annotations.simple_test_annotation;

// Программа, содержащая аннотацию с параметром
public class Sample2 {

    // Тест должен быть пройден
    @ExceptionTest(ArithmeticException.class)
    public static void ml () {
        int i = 0;
        i = i / i;
    }

    // Тест не должен быть пройден
    // неверное исключение ArrayIndexOutOfBoundsException
    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }

    // Тест не должен быть пройден
    // нет никакого исключения
    @ExceptionTest(ArithmeticException.class)
    public static void m3() {

    }

}
