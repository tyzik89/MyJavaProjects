package com.work.vladimirs.patterns.proxy.protective_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler {

    private Person person;

    public OwnerInvocationHandler(Person person) {
        this.person = person;
    }

    /**
     * Обработчик вызовов для владельца.
     * При каждом вызове метода заместителя вызывается метод invoke.
     * Как же при вызове invoke() заместителя определить, что делать с этим
     * вызовом? Обычно решение принимается на основании анализа имени
     * метода и, возможно, аргументов.
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().startsWith("get")) {
                // Если вызван get-метод, вызов передается реальному объекту.
                return method.invoke(person, args);//
            } else if (method.getName().equals("setGeekRating")) {
                // Вызов метода setGeekRating() блокируется выдачей исключения IllegalAccessException.
                throw new IllegalAccessException();
            } else if (method.getName().startsWith("set")) {
                // Вызов любых других set-методов владельцу разрешен, передаем реальному объекту.
                return method.invoke(person, args);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // Вызов любоого другого метода возвращает null, для избежания лишнего риска.
        return null;
    }
}
