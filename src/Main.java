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
        switch (input){
            case "+":
                System.out.println(randomNumber1+randomNumber2);
                break;
            case "-":
                System.out.println(randomNumber1-randomNumber2);
                break;
            case "*":
                System.out.println(randomNumber1*randomNumber2);
                break;
            default:
                System.out.println("Error. The operation is unclear.");
        }


    }
}