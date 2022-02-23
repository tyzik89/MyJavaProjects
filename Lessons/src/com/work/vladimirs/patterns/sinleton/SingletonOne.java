package com.work.vladimirs.patterns.sinleton;

/**
 * С условной блокировкой
 */
public class SingletonOne {

    private volatile static SingletonOne uniqueInstance;

    private int filed_1;

    private SingletonOne() {

    }

    public static SingletonOne getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonOne.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonOne();
                }
            }
        }
        return uniqueInstance;
    }

    public void setFiled_1(int filed_1) {
        this.filed_1 = filed_1;
    }

    @Override
    public String toString() {
        return "SingletonOne{" +
                "filed_1=" + filed_1 +
                '}';
    }
}
