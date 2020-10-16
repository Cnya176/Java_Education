package com.company;
import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {

        System.out.println(integralTrapez(0, 2, x -> { return Math.pow(x, 2) + (Math.sin(2*x)) + x - 3; }));
        more();
    }

    public static double integralTrapez(double a, double b, Function function){

        double area=0;

        double h=0.001;

        for (int i=0; i<(b-a)/h; i++){

            area += h * (0.5 * (function.func(a + i * h)+function.func(a+(i+1)*h)));

        }

        return area;
    }

    public static void more(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Again? Enter 'y' or 'n' ");
        String input = scanner.nextLine();

        if (input.equals("n")){ }
        else {
            main();
        }

    }

    private static void main() {

        System.out.println(integralTrapez(0, 2, x -> { return Math.pow(x, 2) + (Math.sin(2*x)) + x - 3; }));
        more();

    }

}

interface Function{

    public double func(double x);

}
