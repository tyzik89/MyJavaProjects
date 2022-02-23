package com.work.vladimirs.patterns.sinleton;

/**
 * С использованием перечислений
 */
public enum SingletonTwo {
    UNIQUE_INSTANCE;

    private int filed_1;

    public void setFiled_1(int filed_1) {
        this.filed_1 = filed_1;
    }

    @Override
    public String toString() {
        return "SingletonTwo{" +
                "filed_1=" + filed_1 +
                '}';
    }
}
