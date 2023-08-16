package com.work.vladimirs.annotations.simple_test_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
* Указывает, что аннотированный метод является тестовым.
* Используется только для статических методов без параметров.
*/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
