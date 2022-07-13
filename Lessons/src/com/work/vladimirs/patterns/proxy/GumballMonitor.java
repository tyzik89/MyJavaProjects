package com.work.vladimirs.patterns.proxy;

public class GumballMonitor {

    private GumballMachine gumballMachine;

    public GumballMonitor(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void report() {
        System.out.println("-------Report-------");
        System.out.println("Gumball Machine: " + gumballMachine.getLocation());
        System.out.println("Current inventory: " + gumballMachine.getNumberGumballs() + " gumballs");
        System.out.println("Current state: " + gumballMachine.getStateName());
        System.out.println("-------End report-------");
    }
}
