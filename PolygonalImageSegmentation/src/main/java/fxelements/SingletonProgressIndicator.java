package fxelements;

import javafx.scene.control.ProgressIndicator;

public class SingletonProgressIndicator {

    private ProgressIndicator progressIndicator;

    private SingletonProgressIndicator(){}

    private static SingletonProgressIndicator INSTANCE = new SingletonProgressIndicator();

    public static SingletonProgressIndicator getInstance()
    {
        return INSTANCE;
    }

    public ProgressIndicator getProgressIndicator() {
        return progressIndicator;
    }

    public ProgressIndicator setProgressIndicator() {
        return progressIndicator;
    }
}
