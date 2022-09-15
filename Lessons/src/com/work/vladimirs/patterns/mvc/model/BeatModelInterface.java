package com.work.vladimirs.patterns.mvc.model;

import com.work.vladimirs.patterns.mvc.view.BPMObserver;
import com.work.vladimirs.patterns.mvc.view.BeatObserver;

public interface BeatModelInterface {

    //Методы, используемые контроллером для управления моделью на основании действий пользователя.
    void initialize();

    void on();

    void off();

    void setBPM(int bpm);

    int getBPM();


    // Методы, при помощи которых представление и контроллер получают информацию состояния и изменяют
    // свой статус наблюдателя.
    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);
}
