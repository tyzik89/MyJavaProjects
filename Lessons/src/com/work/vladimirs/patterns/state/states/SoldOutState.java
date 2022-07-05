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
        System.out.println("You cannot insert a quarter, because all gumballs was sold.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter, and all gumballs was sold.");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there’s no quarter and all gumballs was sold.");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first, but all gumballs was sold.");
    }
}
