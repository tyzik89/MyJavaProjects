package com.work.vladimirs.annotations.simple_test_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Тип аннотации с параметром
 * ---
 * Указывает, что аннотированный метод является
 * тестирующим методом, который для успешного завершения
 * должен генерировать указанное исключение
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}
