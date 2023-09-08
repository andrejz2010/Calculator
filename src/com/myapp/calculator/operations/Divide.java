package com.myapp.calculator.operations;

import com.myapp.calculator.operations.Calculation;

public class Divide implements Calculation {
    public Divide() {
    }
    @Override
    public double calculate(double num1, double num2) {
        return num1/num2;
    }}