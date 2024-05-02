package template;

import controllers.FindByCountry;

import java.util.Scanner;

public class Message_template {

    public static void msgMenu(boolean rerun) {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*   Select from below the operation you want  *");
        System.out.println("*   > 1. Currency converter                   *");
        System.out.println("*   > 2. Historical Conversion                *");
        System.out.println("*   > 3. Search currency by country           *");
        System.out.println("*   > 4. Watch list currencies code           *");
        System.out.println("*   > 0. Exit                                 *");
        stars();
    }

    public static void supportedCurrencies(Scanner sc) {
        String confirm;
        boolean badTypo = false;
        stars();
        Console.color("Type below the country you would like to see the currency code:", Console.YELLOW);
        FindByCountry.showSupported(sc.nextLine());
        confirm = sc.nextLine();
        do {
            if (confirm.equals("y") || confirm.equals("Y")) {
                lines();
                Console.color("Type below the country you would like to see the currency code:", Console.YELLOW);
                FindByCountry.showSupported(sc.nextLine());
                confirm = sc.nextLine();
            } else if (confirm.equals("n") || confirm.equals("N")) {
                badTypo = true;
            } else {
                lines();
                Console.color("That option is invalid", Console.RED);
                Console.color("Type 'y' for YES || Type 'n' for NO", Console.YELLOW);
                lines();
                confirm = sc.nextLine();
            }
        } while (!badTypo);
        Message_template.stars();
    }

    public static void lines() {
        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
    }

    public static void stars() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
    }
}
