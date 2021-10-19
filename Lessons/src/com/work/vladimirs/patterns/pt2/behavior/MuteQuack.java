package com.work.vladimirs.patterns.pt2.behavior;

/**
 * Реализация интерфейса крякания
 * Своеобразная заглушка поведения крякания, т.е. крякание отсутствует
 */
public class MuteQuack implements QuackBehavior{

    @Override
    public void quck() {
        System.out.println("<< Silence >>");
    }
}
