package com.work.vladimirs.patterns.state.states;

import com.work.vladimirs.patterns.state.GumballMachine;

/**
 * Состояние когда жевачки нет - всё распродано.
 */
public class SoldOutState implements State {

    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
