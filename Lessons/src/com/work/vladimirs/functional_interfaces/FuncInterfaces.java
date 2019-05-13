package com.work.vladimirs.functional_interfaces;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuncInterfaces {

    public static void main(String[] args) {
        Predicate<Object> condition = o -> Objects.isNull(o);

        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = cs -> cs.length();

        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength.apply(null));
        System.out.println(safeStringLength.apply(""));
        System.out.println(safeStringLength.apply("Hello World!"));
    }

    private static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return new Function<T, U>() {
            @Override
            public U apply(T x) {
                return condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
            }
        };

    }
}
