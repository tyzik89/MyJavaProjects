package com.work.vladimirs.patterns.mvc.model;

import com.work.vladimirs.patterns.mvc.view.BPMObserver;
import com.work.vladimirs.patterns.mvc.view.BeatObserver;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BeatModel implements BeatModelInterface, Runnable {

    // Наблюдатели делятся на две группы:
    // 1) те, которые должны оповещаться о каждом ударе,
    // 2) те, которые должны оповещаться только об изменениях частоты.
    List<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
    List<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();

    // Частота ритма
    int bpm = 90;

    // Используются для запуска и остановки потока ритма.
    Thread thread;
    boolean stop = false;

    // Аудиоклип, который будет воспроизводиться.
    Clip clip;

    @Override
    public void initialize() {
        try {
            File resource = new File("src/com/work/vladimirs/patterns/mvc/clap.wav");
            clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            clip.open(AudioSystem.getAudioInputStream(resource));
        }
        catch(Exception ex) {
            System.out.println("Error: Can’t load clip");
            System.out.println(ex);
        }
    }

    /**
     * В методе on() назначаем частоту по умолчанию и запускаем поток для воспроизведения ритма.
     */
    @Override
    public void on() {
        bpm = 90;
        notifyBPMObservers();
        thread = new Thread(this);
        stop = false;
        thread.start();
    }

    /**
     * метод off() обнуляет ритм и останавливает поток, воспроизводящий ритм.
     */
    @Override
    public void off() {
        stopBeat();
        stop = true;
    }

    /**
     * Метод setBPM() используется контроллером для управления ритмом. Он задает переменную bpm
     * и уведомляет всех наблюдателей BPM об изменении частоты.
     */
    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        notifyBPMObservers();
    }

    /**
     * Метод getBPM() возвращает текущую частоту ритма.
     */
    @Override
    public int getBPM() {
        return bpm;
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        beatObservers.remove(o);
    }

    @Override
    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        bpmObservers.remove(o);
    }

    /**
     * Метод run() запускает ритмический поток, воспроизводит ритм, определяемый
     * величиной BPM, и уведомляет наблюдателей о воспроизведении ритма. Цикл завершается
     * при выборе команды Stop в меню.
     */
    @Override
    public void run() {
        while (!stop) {
            playBeat();
            notifyBeatObservers();
            try {
                Thread.sleep(60000/getBPM());
            } catch (Exception e) {}
        }
    }

    private void notifyBeatObservers() {
        for (int i = 0; i < beatObservers.size(); i++) {
            BeatObserver observer = beatObservers.get(i);
            observer.updateBeat();
        }
    }

    private void notifyBPMObservers() {
        for (BPMObserver bpmObserver : bpmObservers) {
            bpmObserver.updateBPM();
        }
    }

    public void playBeat() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void stopBeat() {
        clip.setFramePosition(0);
        clip.stop();
    }

}
