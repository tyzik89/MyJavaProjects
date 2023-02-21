package com.work.vladimirs.streams_and_functions.mail_system_last_stepic;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Message<T>> {

    //Переопределяем свой метод хэш мапы, чтобы get никогда не возвращал null в значении.
    private Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            // Collections.emptyList() возвращает один и тот же экземпляр
            // неизменяемого списка. Если бы мы возвращали здесь, допустим,
            // new ArrayList<>(), то множество вызовов get по отсутвующему
            // элементу создавало бы множество лишних объектов.
            return this.containsKey(key) ? super.get(key) : Collections.emptyList();
            //return super.getOrDefault(key, new LinkedList<T>());
        }
    };

    Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    void setMailBox(Map<String, List<T>> mailBox) {
        this.mailBox = mailBox;
    }

    @Override
    public void accept(Message<T> tMessage) {
        List<T> values = mailBox.get(tMessage.getTo());
        if (values.size() == 0) {
            values = new LinkedList<>();
        }
        values.add(tMessage.getContent());
        mailBox.put(tMessage.getTo(), values);
    }

    @Override
    public Consumer<Message<T>> andThen(Consumer<? super Message<T>> after) {
        return null;
    }
}
