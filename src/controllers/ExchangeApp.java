package controllers;

import models.SupportedCurrenciesDTO;
import repository.SavedConversion;
import template.Console;
import template.Message_template;

import java.util.InputMismatchException;
import java.util.Scanner;

import static controllers.InputValidator.verifyInput;

public class ExchangeApp {

    private static boolean firstAttempt = false;
    private static boolean rerun = false;
    private static final Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        if (!firstAttempt) {
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*   Welcome to our Exchange Rate System:      *");
            firstAttempt = true;
        }
        int option;
        do {
            Message_template.msgMenu(rerun);
            System.out.println();
            Console.inputColor("Type your option > ", Console.BLUE);
            option = verifyInput(sc);
            sc.nextLine();
            System.out.println();
            switch (option) {
                case 1:
                    API.requestMapping();
                    break;
                case 2:
                    SavedConversion.checkTable();
                    break;
                case 3:
                    Message_template.supportedCurrencies(sc);
                    break;
                case 4:
                    SupportedCurrenciesDTO.fullTable();
                    break;
                case 0:
                    break;
                default:
                    Message_template.stars();
                    System.out.println();
                    Console.color("That option is not valid", Console.RED);
                    System.out.println();
            }
            rerun = true;
        } while (option != 0);
        Message_template.stars();
        System.out.println();
        System.out.println("======== Thank for using our Exchange APP ========");
        sc.close();
    }
}


