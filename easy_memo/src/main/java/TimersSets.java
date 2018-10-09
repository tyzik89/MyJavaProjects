public final class TimersSets {
    private int notEarlierMS;
    private int notLaterMS;

    public TimersSets() {
        this.notEarlierMS = 2000;
        this.notLaterMS = 5000;
    }

    public int getNotEarlier() {
        return notEarlierMS;
    }

    public void setNotEarlier(int notEarlier) {
        this.notEarlierMS = notEarlier;
    }

    public int getNotLater() {
        return notLaterMS;
    }

    public void setNotLater(int notLater) {
        this.notLaterMS = notLater;
    }
}
