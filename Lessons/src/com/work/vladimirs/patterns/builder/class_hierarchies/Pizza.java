package com.work.vladimirs.patterns.builder.class_hierarchies;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE;}
    final Set<Topping> toppings;

    //Обобщённый тип с рекурсивным параметром типа
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        //Подклассы должны переопределять этот метод, возвращая "себя"
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
