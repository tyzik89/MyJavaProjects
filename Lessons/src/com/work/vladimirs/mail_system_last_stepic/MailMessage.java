package com.work.vladimirs.mail_system_last_stepic;

public class MailMessage extends AbstractMessage<String>  {

    private String content;

    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}
