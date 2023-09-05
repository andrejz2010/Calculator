import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random random= new Random();
        int randomNumber1= random.nextInt(100);
        int randomNumber2= random.nextInt(100);
        System.out.print("Please enter an operation \"+\", \"-\" or \"*\"   ");
        Scanner scanner = new Scanner(System.in);

        int result=0;
        String input = scanner.next();
        System.out.print("Please enter first number:   ");
        double number1 = scanner.nextDouble();
        System.out.print("Please enter second number:   ");
        double number2 = scanner.nextDouble();
        switch (input){
            case "+":
                System.out.println(number1+number2);
                break;
            case "-":
                System.out.println(number1-number2);
                break;
            case "*":
                System.out.println(number1*number2);
                break;
            default:
                System.out.println("Error. The operation is unclear.");
        }


    }
}