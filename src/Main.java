import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        double result=0;
        Scanner scanner = new Scanner(System.in);



        FileWriter writer = new FileWriter("/Users/andrejzacharov/JavaProjects/Calculator/src/Result.txt");
        String writeLn;


        System.out.print("Enter file name: ");
        String fileReaderName = scanner.next();
        String filePathForReader="/Users/andrejzacharov/JavaProjects/Calculator/src/"+fileReaderName;
        Path filePath = Paths.get(filePathForReader);
        Scanner scanner2 = new Scanner(filePath);


        List<Integer> integers = new ArrayList<>();
        while (scanner2.hasNext()) {
            if (scanner2.hasNextInt()) {
                integers.add(scanner2.nextInt());
            } else {
                scanner2.next();
            }
        }






        System.out.print("Please enter an operation \"+\", \"-\", \"/\" or \"*\"   ");
        String operator = scanner.next();


        

       


        if (integers.size() <= 1 ) {

            System.out.println("You need to have file with at  least 2 numbers");
            System.exit(0);

        }




        double NewResult=integers.get(0);
        switch (operator){
            case "/":
                Divide divide =new Divide();
                for (int i = 0; i < integers.size()-1; i++) {
                    writeLn=NewResult+" / " + integers.get(i+1)+" = "+divide.calculate(NewResult,integers.get(i+1))+"\n";
                    NewResult=divide.calculate(NewResult,integers.get(i+1));
                    writer.write(writeLn);
                    result = NewResult;
                }
                System.out.printf("Result: %.4f",result);
                break;
            case "+":
                Add add =new Add();
                for (int i = 0; i < integers.size()-1; i++) {
                    writeLn=NewResult+" + " + integers.get(i+1)+" = "+add.calculate(NewResult,integers.get(i+1))+"\n";
                    NewResult=add.calculate(NewResult,integers.get(i+1));
                    writer.write(writeLn);
                    result = NewResult;
                }
                System.out.printf("Result: %.4f",result);
                break;
            case "-":
                Subtract subtract =new Subtract();
                for (int i = 0; i < integers.size()-1; i++) {
                    writeLn=NewResult+" - " + integers.get(i+1)+" = "+subtract.calculate(NewResult,integers.get(i+1))+"\n";
                    NewResult=subtract.calculate(NewResult,integers.get(i+1));
                    writer.write(writeLn);
                    result = NewResult;
                }
                System.out.printf("Result: %.4f", result);
                break;
            case "*":
                Multiply multiply =new Multiply();
                for (int i = 0; i < integers.size()-1; i++) {
                    long value = Long.parseLong(NewResult.);
                    writeLn=NewResult+" * " + integers.get(i+1)+" = "+multiply.calculate(NewResult,integers.get(i+1))+"\n";
                    NewResult=multiply.calculate(NewResult,integers.get(i+1));
                    writer.write(writeLn);
                    result = NewResult;
                }
                System.out.printf("Result: %.4f", result);
                break;
            default:
                System.out.println("Error. The operation is unclear.");
        }
        writer.close();

    }



}