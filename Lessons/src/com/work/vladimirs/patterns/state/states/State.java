package com.work.vladimirs.patterns.state.states;

/**
 * Интерфейс состояния с методами возможных действий. Т.е. для каждого состояния создаётся свой класс.
 */
public interface State {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
