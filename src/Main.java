import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double result=0;
        Scanner scanner = new Scanner(System.in);


        System.out.print("Please enter an operation \"+\", \"-\", \"/\" or \"*\"   ");
        String operator = scanner.next();

        System.out.print("How many numbers?   ");
        int numberOfNumbers = scanner.nextInt();
        if (numberOfNumbers<=1){
            System.out.println("You need to enter at least 2 numbers");
            System.exit(0);

        }

        double[] numbersInArray = new double[numberOfNumbers];

        for (int i = 0; i < numberOfNumbers; i++) {
            System.out.printf("Please enter number %d:   %n", i+1);
            double number = scanner.nextDouble();
            numbersInArray[i]= number;
        }

        double NewResult=numbersInArray[0];
        switch (operator){
            case "/":
                Divide divide =new Divide();
                for (int i = 0; i < numbersInArray.length-1; i++) {
                    NewResult=divide.calculate(NewResult,numbersInArray[i+1]);
                    result = NewResult;
                }
                System.out.println(result);
                break;
            case "+":
                Add add =new Add();
                for (int i = 0; i < numbersInArray.length-1; i++) {
                    NewResult=add.calculate(NewResult,numbersInArray[i+1]);
                    result = NewResult;
                }
                System.out.println(result);
                break;
            case "-":
                Subtract subtract =new Subtract();
                for (int i = 0; i < numbersInArray.length-1; i++) {
                    NewResult=subtract.calculate(NewResult,numbersInArray[i+1]);
                    result = NewResult;
                }
                System.out.println(result);
                break;
            case "*":
                Multiply multiply =new Multiply();
                for (int i = 0; i < numbersInArray.length-1; i++) {
                    NewResult=multiply.calculate(NewResult,numbersInArray[i+1]);
                    result = NewResult;
                }
                System.out.println(result);
                break;
            default:
                System.out.println("Error. The operation is unclear.");
        }


    }
}