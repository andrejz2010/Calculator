package com.myapp.calculator.operations;

import com.myapp.calculator.operations.Calculation;

public class Multiply implements Calculation {
    public Multiply() {
    }
    @Override
    public double calculate(double num1, double num2) {
        return num1*num2;
    }}