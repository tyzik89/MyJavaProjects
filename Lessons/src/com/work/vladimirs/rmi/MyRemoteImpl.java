package com.work.vladimirs.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Служба должна реализовать интерфейс удаленного доступа — интерфейс, методы которого будут
 * вызываться клиентом.
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {


    /**
     * UnicastRemoteObject реализует интерфейс Serializable, поэтому понадобится поле serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Размещать код в конструкторе не нужно. Это всего лишь способ объявить,
     * что конструктор суперкласса инициирует исключение.
     */
    public MyRemoteImpl() throws RemoteException { }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says, ‘Hey’";
    }
}
