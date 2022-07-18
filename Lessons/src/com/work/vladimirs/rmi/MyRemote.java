package com.work.vladimirs.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Интерфейс будет использоваться для поддержки удаленных вызовов.
 * Вызовы удаленных методов считаются «рискованными». Объявление RemoteException в каждом методе обращает
 * внимание клиента на то, что вызов может не сработать.
 */
public interface MyRemote extends Remote {

    /**
     * Аргументы и возвращаемые значения должны быть примитивами или Serializable
     */
    String sayHello() throws RemoteException;
}
