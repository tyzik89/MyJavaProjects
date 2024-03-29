package com.work.vladimirs.patterns.proxy.remote_proxy.machine.states;

import com.work.vladimirs.patterns.proxy.remote_proxy.machine.GumballMachine;

import java.util.Random;

/**
 * Состояние, когда в аппарат бросили монетку
 */
public class HasQuarterState implements State {

    private static final long serialVersionUID = 2L;

    /**
     * В каждой реализации State переменная экземпляра GumballMachine помечается ключевым словом
     * transient. Оно сообщает JVM, что это поле не сериализуется.
     */
    private transient GumballMachine gumballMachine;
    private Random randomWinner = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can’t insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (gumballMachine.getNumberGumballs() > 1)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
