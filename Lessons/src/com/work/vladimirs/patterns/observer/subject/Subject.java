package com.work.vladimirs.patterns.observer.subject;

import com.work.vladimirs.patterns.observer.observers.Observer;

public interface Subject {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();

}
