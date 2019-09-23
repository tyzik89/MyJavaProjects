package elements;

import javafx.scene.control.ProgressBar;

public class SingletonProcessBar
{
    private ProgressBar progressBar;

    private SingletonProcessBar(){}

    private static SingletonProcessBar INSTANCE = new SingletonProcessBar();

    public static SingletonProcessBar getInstance()
    {
        return INSTANCE;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public ProgressBar setProgressBar() {
        return progressBar;
    }
}
