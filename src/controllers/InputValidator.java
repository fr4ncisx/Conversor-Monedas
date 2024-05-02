package controllers;

import template.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    public static int verifyInput(Scanner sc){
        while(true){
            try {
                return sc.nextInt();
            } catch(InputMismatchException e){
                System.out.println();
                Console.color("That's not a valid input!", Console.RED);
                sc.nextLine();
                Console.inputColor("Type your option again: ", Console.PURPLE);
            }
        }
    }
}
