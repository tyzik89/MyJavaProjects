package com.work.vladimirs.streams_and_functions.mail_system_last_stepic;

public abstract class AbstractMessage<T> implements Message<T> {

    private String from;
    private String to;
    private T content;

    public AbstractMessage(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public T getContent() {
        return content;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public String getFrom() {
        return from;
    }
}
