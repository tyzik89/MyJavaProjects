package com.work.vladimirs.mail_system_last_stepic;

public class SalaryMessage extends AbstractMessage<Integer> {

    public SalaryMessage(String from, String to, Integer salary) {
        super(from, to, salary);
    }

}
