package com.work.vladimirs.DOM.DOM_2;

public class Worker extends Human{
    private String position;

    public Worker(String name, String position) {
        super(name);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public String toString() {
        return "Сотрудник обслуживающего персонала " + getName() + ", должность: " + position;
    }
}
