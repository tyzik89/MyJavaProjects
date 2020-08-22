package com.work.vladimirs.threads.thread_wait_notify;

class Car {

    //Флаг успешного нанесения воска и готовности машины к полировке
    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;   //готово к полировке
        notifyAll();
    }

    public synchronized void polish() {
        waxOn = false;  //готово к нанесению слоя воска
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        //Пока слой воска не нанесён
        while (!waxOn) {
            wait();
        }
    }

    public synchronized void waitForPolish() throws InterruptedException {
        //Пока полировка не закончена
        while (waxOn) {
            wait();
        }
    }
}
