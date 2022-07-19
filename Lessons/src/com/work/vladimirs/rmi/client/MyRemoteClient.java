package com.work.vladimirs.rmi.client;

import com.work.vladimirs.rmi.MyRemote;

import java.rmi.Naming;

public class MyRemoteClient {

    public void go() {
        try {
            // Возвращается из реестра в виде типа Object
            MyRemote service = (MyRemote) Naming.lookup("rmi://localhost/RemoteHello");
            String s = service.sayHello();
            System.out.println(s);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyRemoteClient().go();
    }
}
