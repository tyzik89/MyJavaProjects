package com.work.vladimirs.patterns.proxy.remote_proxy.machine.states;

import com.work.vladimirs.patterns.proxy.remote_proxy.machine.GumballMachine;

/**
 * Состояние, когда жевачка куплена
 */
public class SoldState implements State {

    private static final long serialVersionUID = 2L;

    /**
     * В каждой реализации State переменная экземпляра GumballMachine помечается ключевым словом
     * transient. Оно сообщает JVM, что это поле не сериализуется.
     */
    private transient GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we’re already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn’t get you another gumball!");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getNumberGumballs() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
