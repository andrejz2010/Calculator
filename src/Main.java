import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        System.out.print("Please enter an operation \"+\", \"-\", \"/\" or \"*\"   ");
        Scanner scanner = new Scanner(System.in);

        double result=0;
        String input = scanner.next();
        System.out.print("Please enter first number:   ");
        double number1 = scanner.nextDouble();
        System.out.print("Please enter second number:   ");
        double number2 = scanner.nextDouble();
        switch (input){
            case "/":
                Divide divide =new Divide();
                result=divide.calculate(number1,number2);
                System.out.println(result);
                break;
            case "+":
                Add add = new Add();
                result=add.calculate(number1, number2);
                System.out.println(result);
                break;
            case "-":
                Subtract subtract = new Subtract();
                result=subtract.calculate(number1, number2);
                System.out.println(result);
                break;
            case "*":
                Multiply multiply = new Multiply();
                result=multiply.calculate(number1,number2);
                System.out.println(result);
                break;
            default:
                System.out.println("Error. The operation is unclear.");
        }


    }
}