package com.work.vladimirs.other.calculator;

import java.util.Objects;

public class Operation {

    private double operandOne;
    private double operandTwo;
    private String operation;

    public Operation(double operandOne, double operandTwo, String operation) {
        this.operandOne = operandOne;
        this.operandTwo = operandTwo;
        this.operation = operation;
    }

    public double getOperandOne() {
        return operandOne;
    }

    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public double getOperandTwo() {
        return operandTwo;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operation)) return false;

        Operation operation1 = (Operation) o;

        if (Double.compare(operation1.operandOne, operandOne) != 0) return false;
        if (Double.compare(operation1.operandTwo, operandTwo) != 0) return false;
        return Objects.equals(operation, operation1.operation);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(operandOne);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(operandTwo);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }
}
