package com.work.vladimirs.patterns.proxy.remote_proxy.machine.states;

import com.work.vladimirs.patterns.proxy.remote_proxy.machine.GumballMachine;

/**
 * Состояние, когда в аппарате нет монетки
 */
public class NoQuarterState implements State {

    private static final long serialVersionUID = 2L;
    /**
     * В каждой реализации State переменная экземпляра GumballMachine помечается ключевым словом
     * transient. Оно сообщает JVM, что это поле не сериализуется.
     */
    private transient GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        // Переход автомата в новое состояние
        gumballMachine.setState(gumballMachine.getHasQuarterState());
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
        System.out.println("You need to pay first");
    }
}
