package com.work.vladimirs.patterns.proxy.protective_proxy;

public interface Person {

    // Info about candidate
    String getName();
    String getGender();
    String getInterests();
    int getGeekRating();

    // Recording methods
    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setGeekRating(int rating);

}
