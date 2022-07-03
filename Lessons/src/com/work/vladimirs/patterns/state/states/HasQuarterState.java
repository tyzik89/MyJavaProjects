package com.work.vladimirs.patterns.state.states;

import com.work.vladimirs.patterns.state.GumballMachine;

/**
 * Состояние, когда в аппарат бросили монетку
 */
public class HasQuarterState implements State {

    private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
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
