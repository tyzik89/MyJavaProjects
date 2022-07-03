package com.work.vladimirs.patterns.state.states;

import com.work.vladimirs.patterns.state.GumballMachine;

/**
 * Состояние, когда выпал 10%-й шанс, и надо выдать две жвачки.
 */
public class WinnerState implements State {

    private GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
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
