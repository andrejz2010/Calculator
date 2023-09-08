package com.myapp.calculator;

import com.myapp.calculator.operations.Add;
import com.myapp.calculator.operations.Divide;
import com.myapp.calculator.operations.Multiply;
import com.myapp.calculator.operations.Subtract;
import com.myapp.util.ValidationUtil;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.myapp.util.ValidationUtil.isInputValid;
import static com.myapp.util.ValidationUtil.isResultValid;

public class Main {
    public static void main(String[] args) throws IOException {
        double result = 0;
        Scanner scanner = new Scanner(System.in);


        FileWriter writer = new FileWriter("/Users/andrejzacharov/JavaProjects/Calculator/src/Result.txt");
        String writeLn;

        System.out.print("Enter file name: ");
        String fileReaderName = scanner.next();
        String filePathForReader = "/Users/andrejzacharov/JavaProjects/Calculator/src/" + fileReaderName;
        Path filePath = Paths.get(filePathForReader);
        Scanner scanner2 = new Scanner(filePath);

        List<Integer> integers = new ArrayList<>();
        while (scanner2.hasNext()) {
            if (scanner2.hasNextInt()) {
                int nextInt = scanner2.nextInt();
                if (ValidationUtil.isInputValid(nextInt)) { // Use ValidationUtil
                    integers.add(nextInt);
                } else {
                    System.out.println("Input value is too large: " + nextInt);
                    System.exit(0);
                }
            } else {
                scanner2.next();
            }
        }

        System.out.print("Please enter an operation \"+\", \"-\", \"/\" or \"*\"   ");
        String operator = scanner.next();

        if (integers.size() <= 1) {
            System.out.println("You need to have a file with at least 2 numbers");
            System.exit(0);
        }

        double NewResult = integers.get(0);
        switch (operator) {
            case "/":
                Divide divide = new Divide();
                for (int i = 0; i < integers.size() - 1; i++) {
                    double tempResult = divide.calculate(NewResult, integers.get(i + 1));
                    if (isResultValid(tempResult)) {
                        writeLn = NewResult + " / " + integers.get(i + 1) + " = " + tempResult + "\n";
                        NewResult = tempResult;
                        writer.write(writeLn);
                        result = NewResult;
                    } else {
                        throw new ArithmeticException("Result is too large: " + tempResult);
                    }
                }
                System.out.printf("Result: %.4f", result);
                break;
            case "+":
                Add add = new Add();
                for (int i = 0; i < integers.size() - 1; i++) {
                    double tempResult = add.calculate(NewResult, integers.get(i + 1));
                    if (isResultValid(tempResult)) {
                        writeLn = NewResult + " + " + integers.get(i + 1) + " = " + tempResult + "\n";
                        NewResult = tempResult;
                        writer.write(writeLn);
                        result = NewResult;
                    } else {
                        throw new ArithmeticException("Result is too large: " + tempResult);
                    }
                }
                System.out.printf("Result: %.4f", result);
                break;
            case "-":
                Subtract subtract = new Subtract();
                for (int i = 0; i < integers.size() - 1; i++) {
                    double tempResult = subtract.calculate(NewResult, integers.get(i + 1));
                    if (isResultValid(tempResult)) {
                        writeLn = NewResult + " - " + integers.get(i + 1) + " = " + tempResult + "\n";
                        NewResult = tempResult;
                        writer.write(writeLn);
                        result = NewResult;
                    } else {
                        throw new ArithmeticException("Result is too large: " + tempResult);
                    }
                }
                System.out.printf("Result: %.4f", result);
                break;
            case "*":
                Multiply multiply = new Multiply();
                for (int i = 0; i < integers.size() - 1; i++) {
                    double tempResult = multiply.calculate(NewResult, integers.get(i + 1));
                    if (isResultValid(tempResult)) {
                        writeLn = NewResult + " * " + integers.get(i + 1) + " = " + tempResult + "\n";
                        NewResult = tempResult;
                        writer.write(writeLn);
                        result = NewResult;
                    } else {
                        throw new ArithmeticException("Result is too large: " + tempResult);
                    }
                }
                System.out.printf("Result: %.4f", result);
                break;
            default:
                System.out.println("Error. The operation is unclear.");
        }
        writer.close();
    }

    // Helper method to check if input is not bigger than 2 billion

}
