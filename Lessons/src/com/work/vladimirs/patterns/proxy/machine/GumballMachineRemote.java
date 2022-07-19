package com.work.vladimirs.patterns.proxy.machine;

import com.work.vladimirs.patterns.proxy.machine.states.State;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballMachineRemote extends Remote {

    int getNumberGumballs() throws RemoteException;

    String getLocation() throws RemoteException;

    State getState() throws RemoteException;
}
