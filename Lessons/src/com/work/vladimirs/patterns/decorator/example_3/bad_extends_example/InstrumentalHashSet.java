package com.work.vladimirs.patterns.decorator.example_3.bad_extends_example;

import java.util.Collection;
import java.util.HashSet;

class InstrumentalHashSet<E> extends HashSet<E> {

    // Количество попыток вставки элементов
    private int addCount = 0;

    public InstrumentalHashSet() {

    }

    public InstrumentalHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
