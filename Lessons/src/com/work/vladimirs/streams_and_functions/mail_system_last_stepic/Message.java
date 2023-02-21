package com.work.vladimirs.streams_and_functions.mail_system_last_stepic;

public interface Message<T> {

    T getContent ();

    String getTo ();

    String getFrom();
}
