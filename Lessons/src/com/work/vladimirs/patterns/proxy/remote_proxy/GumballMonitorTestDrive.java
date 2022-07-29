package com.work.vladimirs.patterns.proxy.remote_proxy;

import com.work.vladimirs.patterns.proxy.remote_proxy.machine.GumballMachineRemote;

import java.rmi.Naming;

public class GumballMonitorTestDrive {

    public static void main(String[] args) {
        String[] location = {"rmi://santafe.mightygumball.com/gumballmachine",
                "rmi://localhost/gumballmachine"};
        GumballMonitor[] monitor = new GumballMonitor[location.length];
        for (int i = 0; i < location.length; i++) {
            try {
                GumballMachineRemote machine =
                        (GumballMachineRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
                System.out.println("=======================================================================");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < monitor.length; i++) {
            GumballMonitor gumMonitor = monitor[i];
            if (gumMonitor != null) {
                gumMonitor.report();
            }
        }
    }

}
