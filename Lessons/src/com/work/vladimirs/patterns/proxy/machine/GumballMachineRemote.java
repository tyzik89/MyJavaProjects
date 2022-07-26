package com.work.vladimirs.patterns.proxy.machine;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballMachineRemote extends Remote {

    int getNumberGumballs() throws RemoteException;

    String getLocation() throws RemoteException;

    String getStateName() throws RemoteException;
}
