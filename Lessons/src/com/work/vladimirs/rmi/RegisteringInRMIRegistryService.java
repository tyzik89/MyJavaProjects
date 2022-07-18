package com.work.vladimirs.rmi;

import java.rmi.Naming;

/**
 * Чтобы созданная служба стала доступной для удаленных клиентов, следует создать ее экземпляр
 * и поместить его в реестр RMI (который должен работать в системе; в противном случае выпол-
 * нение этой строки кода завершится неудачей). При регистрации объекта реализации система
 * RMI помещает в реестр заглушку, потому что клиент взаимодействует именно с ней. Регистрация
 * службы осуществляется статическим методом rebind() класса java.rmi.Naming.
 */
public class RegisteringInRMIRegistryService {

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
