package com.work.vladimirs.patterns.adapter;

/**
 * Библиотечный класс, который невозможно поменять
 */
public final class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I’m flying a short distance");
    }
}
