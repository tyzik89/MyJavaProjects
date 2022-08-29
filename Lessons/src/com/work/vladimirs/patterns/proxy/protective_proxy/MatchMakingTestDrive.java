package com.work.vladimirs.patterns.proxy.protective_proxy;

import java.lang.reflect.Proxy;

public class MatchMakingTestDrive {

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    public void drive() {
        Person joe = getPersonFromDatabase();
        Person ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());
        ownerProxy.setInterests("bowling, Go");
        System.out.println("Interests set from owner proxy");
        // пытаемся изменить оценку
        try {
            ownerProxy.setGeekRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getGeekRating());

        //==============================================================================================================

        Person nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("football, Java");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }
        nonOwnerProxy.setGeekRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getGeekRating());
    }

    /**
     * Этот метод получает объект Person (данные конкретного человека) и возвращает для него
     * заместитель. Так как заместитель обладает тем же интерфейсом, что и реальный объ-
     * ект, мы возвращаем Person.
     */
    private Person getNonOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(), // Передаем ему загрузчик класса для нашего реального объекта
                person.getClass().getInterfaces(),  // ...и набор интерфейсов, который должен реализовать заместитель
                new NonOwnerInvocationHandler(person));
    }

    /**
     * Этот метод получает объект Person (данные конкретного человека) и возвращает для него
     * заместитель. Так как заместитель обладает тем же интерфейсом, что и реальный объ-
     * ект, мы возвращаем Person.
     */
    Person getOwnerProxy(Person person) {
        //Для создания заместителя используется статический метод newProxyInstance() класса Proxy.
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(), // Передаем ему загрузчик класса для нашего реального объекта
                person.getClass().getInterfaces(),  // ...и набор интерфейсов, который должен реализовать заместитель
                new OwnerInvocationHandler(person)); // ...и обработчик вызова — в нашей ситуации OwnerInvocationHandler
                                                     // Конструктору обработчика передается реальный объект
                                                     // (именно так обработчик получает доступ к реальному объекту).
    }

    private Person getPersonFromDatabase() {
        Person joe = new PersonImpl();
        joe.setName("Joe Javabean");
        joe.setGender("Male");
        joe.setInterests("Bla bla bla");
        joe.setGeekRating(5);
        return joe;
    }

}
