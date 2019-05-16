package com.work.vladimirs.mail_system_last_stepic;

public interface Message<T> {

    T getContent ();

    String getTo ();

    String getFrom();
}
