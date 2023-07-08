package com.work.vladimirs.patterns.decorator.example_3.composition_plus_frowarding_example;

import java.util.Collection;
import java.util.Set;

class InstrumentalHashSet<E> extends ForwardingSet<E>{

    private int addCount = 0;

    public InstrumentalHashSet(Set<E> s) {
        super(s);
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
