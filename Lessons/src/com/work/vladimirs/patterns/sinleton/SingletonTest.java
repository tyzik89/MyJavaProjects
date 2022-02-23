package com.work.vladimirs.patterns.sinleton;

public class SingletonTest {
    public static void main(String[] args) {
        SingletonOne singletonOneFirst = SingletonOne.getInstance();
        singletonOneFirst.setFiled_1(11);
        System.out.println(singletonOneFirst.toString());

        SingletonOne singletonOneSecond = SingletonOne.getInstance();
        System.out.println(singletonOneSecond.toString());



        SingletonTwo singletonTwoFirst = SingletonTwo.UNIQUE_INSTANCE;
        singletonTwoFirst.setFiled_1(22);
        System.out.println(singletonTwoFirst.toString());

        SingletonTwo singletonTwoSecond = SingletonTwo.UNIQUE_INSTANCE;
        System.out.println(singletonTwoSecond.toString());
    }
}
