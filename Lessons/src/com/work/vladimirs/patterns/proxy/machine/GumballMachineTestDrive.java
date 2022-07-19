package com.work.vladimirs.patterns.proxy.machine;

import com.work.vladimirs.patterns.proxy.GumballMonitor;

public class GumballMachineTestDrive {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine("Voronezh",5);
        GumballMonitor monitor = new GumballMonitor(gumballMachine);

        System.out.println(gumballMachine);
        monitor.report();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
        monitor.report();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();

        System.out.println(gumballMachine);
        monitor.report();

        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
        monitor.report();
    }
}
