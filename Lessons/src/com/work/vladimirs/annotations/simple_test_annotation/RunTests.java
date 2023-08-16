package com.work.vladimirs.annotations.simple_test_annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {

    public static void main(String[] args) throws Exception {
        Class<?> testClass_1 = Class.forName("com.work.vladimirs.annotations.simple_test_annotation.Sample");
        test(testClass_1);

        Class<?> testClass_2 = Class.forName("com.work.vladimirs.annotations.simple_test_annotation.Sample2");
        test(testClass_2);
    }

    private static void test(Class<?> testClass) throws Exception {
        int test = 0;
        int passed = 0;
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                test++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception e) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                test++;
                try {
                    m.invoke(null);
                    System.out.printf("Сбой теста %s: нет исключения%n",m);
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    Class <? extends Throwable> expectedTypeException = m.getAnnotation(ExceptionTest.class).value();
                    if (expectedTypeException.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.printf(
                                "Сбой теста %s: ожидался %s, получен %s%n",
                                m, expectedTypeException.getName(), exc);
                    }
                } catch (Exception e) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Пройдено: %d, Сбоев: %d%n", passed, test - passed);
    }
}
