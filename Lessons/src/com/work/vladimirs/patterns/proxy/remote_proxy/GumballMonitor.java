package com.work.vladimirs.patterns.proxy.remote_proxy;

import com.work.vladimirs.patterns.proxy.remote_proxy.machine.GumballMachineRemote;

/**
 * Система мониторинга машин с жвачками (клиент)
 */
public class GumballMonitor {

    private GumballMachineRemote gumballMachineRemote;

    public GumballMonitor(GumballMachineRemote gumballMachineRemote) {
        this.gumballMachineRemote = gumballMachineRemote;
    }

    public void report() {
        try {
            System.out.println("-------Report-------");
            System.out.println("Gumball Machine: " + gumballMachineRemote.getLocation());
            System.out.println("Current inventory: " + gumballMachineRemote.getNumberGumballs() + " gumballs");
            System.out.println("Current state: " + gumballMachineRemote.getStateName());
            System.out.println("-------End report-------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
