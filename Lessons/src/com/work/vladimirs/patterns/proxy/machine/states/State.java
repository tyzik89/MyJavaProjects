package com.work.vladimirs.patterns.proxy.machine.states;

import java.io.Serializable;

/**
 * Интерфейс состояния с методами возможных действий. Т.е. для каждого состояния создаётся свой класс.
 */
public interface State extends Serializable {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
