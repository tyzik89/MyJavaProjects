package com.work.vladimirs.patterns.state;

import com.work.vladimirs.patterns.state.states.*;

/**
 * Торговый автомат, продающий жвательную резинку.
 */
public class GumballMachine {

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state;
    int numberGumballs;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.numberGumballs = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    /**
     * Операция делегируется объекту текущего состояния.
     */
    public void insertQuarter() {
        state.insertQuarter();
    }

    /**
     * Операция делегируется объекту текущего состояния.
     */
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    /**
     * Операция делегируется объекту текущего состояния.
     */
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    /**
     * Перевод автомата в другое состояние
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Вспомогательный метод, который отпускает шарик и уменьшает значение
     * переменной numberGumballs.
     */
    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (this.numberGumballs != 0) {
            this.numberGumballs = this.numberGumballs - 1;
        }
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getNumberGumballs() {
        return numberGumballs;
    }
}
