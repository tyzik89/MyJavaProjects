package com.work.vladimirs.streams_and_functions.mail_system_last_stepic;

public class MailMessage extends AbstractMessage<String>  {

    private String content;

    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}
