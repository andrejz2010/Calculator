import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        double result=0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<Double>();


        System.out.print("Please enter an operation \"+\", \"-\", \"/\" or \"*\"   ");
        String operator = scanner.next();




        System.out.print("Please enter a number  ");
        double firstNumber = scanner.nextDouble();
        numbers.add(firstNumber);

        while(true){
            System.out.print("Please enter next number or write done to finish entering numbers:");
            String NextNumber = scanner.next();
            if(NextNumber == "done" || !isNumberic(NextNumber)) break;
            else if (isNumberic(NextNumber)) {
                double NextDouble= Double.parseDouble(NextNumber);
                numbers.add(NextDouble);
            }
        }


        if (numbers.size() <= 1 ) {

            System.out.println("You need to enter at least 2 numbers");
            System.exit(0);

        }




        double NewResult=numbers.get(0);
        switch (operator){
            case "/":
                Divide divide =new Divide();
                for (int i = 0; i < numbers.size()-1; i++) {
                    NewResult=divide.calculate(NewResult,numbers.get(i+1));
                    result = NewResult;
                }
                System.out.printf("Result: %.4f",result);
                break;
            case "+":
                Add add =new Add();
                for (int i = 0; i < numbers.size()-1; i++) {
                    NewResult=add.calculate(NewResult,numbers.get(i+1));
                    result = NewResult;
                }
                System.out.printf("Result: %.4f",result);
                break;
            case "-":
                Subtract subtract =new Subtract();
                for (int i = 0; i < numbers.size()-1; i++) {
                    NewResult=subtract.calculate(NewResult,numbers.get(i+1));
                    result = NewResult;
                }
                System.out.printf("Result: %.4f", result);
                break;
            case "*":
                Multiply multiply =new Multiply();
                for (int i = 0; i < numbers.size()-1; i++) {
                    NewResult=multiply.calculate(NewResult,numbers.get(i+1));
                    result = NewResult;
                }
                System.out.printf("Result: %.4f", result);
                break;
            default:
                System.out.println("Error. The operation is unclear.");
        }


    }

    public static boolean isNumberic(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }


}