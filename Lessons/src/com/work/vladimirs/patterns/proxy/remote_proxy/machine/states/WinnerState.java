package com.work.vladimirs.patterns.proxy.remote_proxy.machine.states;

import com.work.vladimirs.patterns.proxy.remote_proxy.machine.GumballMachine;

/**
 * Состояние, когда выпал 10%-й шанс, и надо выдать две жвачки.
 */
public class WinnerState implements State {

    private static final long serialVersionUID = 2L;

    /**
     * В каждой реализации State переменная экземпляра GumballMachine помечается ключевым словом
     * transient. Оно сообщает JVM, что это поле не сериализуется.
     */
    private transient GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can’t insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there’s no quarter");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getNumberGumballs() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            System.out.println("YOU’RE A WINNER! You got two gumballs for your quarter");
            if (gumballMachine.getNumberGumballs() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
