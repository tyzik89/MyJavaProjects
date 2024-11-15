package com.work.vladimirs.other.calculator;

import java.util.*;

public class CalculatorServiceBasicImpl implements CalculatorService {

    private static final List<String> AVAILABLE_OPERATIONS = Arrays.asList("+", "-");

    @Override
    public double calculate(String expression) {
        List<String> postfixExpression = transformInfixToPostfix(expression);
        System.out.println(postfixExpression);
        double result = calculatePostfixExpression(postfixExpression);
        System.out.println(result);
        return result;
    }

    private double calculatePostfixExpression(List<String> postfixExpression) {
        ArrayDeque<String> operationQueue = new ArrayDeque<>(postfixExpression.size());
        for (String op : postfixExpression) {
            if (isNumeric(op)) {
                operationQueue.offerFirst(op);
            } else if (isOperation(op)) {
                double operand2 = Double.parseDouble(operationQueue.pollFirst());
                double operand1 = Double.parseDouble(operationQueue.pollFirst());
                String operation = AVAILABLE_OPERATIONS.get(AVAILABLE_OPERATIONS.indexOf(op));
                switch (operation) {
                    case "+": {
                        operationQueue.offerFirst(String.valueOf(operand1 + operand2));
                        break;
                    }
                    case "-": {
                        operationQueue.offerFirst(String.valueOf(operand1 - operand2));
                        break;
                    }
                }
            }
        }
        return Double.parseDouble(operationQueue.getFirst());
    }

    private List<String> transformInfixToPostfix(String expression) {
        ArrayDeque<String> operationQueue = new ArrayDeque<>(AVAILABLE_OPERATIONS.size());
        List<String> result = new ArrayList<>();
        for (String elem : expression.trim().split(" ")) {
            if (isNumeric(elem)) {
                result.add(elem);
            } else if (isOperation(elem)) {
                if (!operationQueue.isEmpty()) {
                    result.add(operationQueue.pollFirst());
                }
                operationQueue.offerFirst(elem);
            } else {
                throw new UnsupportedOperationException();
            }
        }
        if (!operationQueue.isEmpty())
            result.add(operationQueue.pollFirst());
        return result;
    }

    private boolean isOperation(String elem) {
        return AVAILABLE_OPERATIONS.contains(elem);
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
