package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import models.CurrencyDTO;
import models.SupportedCurrenciesDTO;
import repository.SavedConversion;
import template.Console;
import template.Message_template;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class API {
    private static final String api_key = "33e4aa021c6f78bb6c5e73c1";
    private static Double amountMain;
    private static String mainCurrency;
    private static boolean exit = false;
    private static SupportedCurrenciesDTO currencies;


    public static void requestMapping() {
        Scanner sc = new Scanner(System.in);
        currencies = addCurrencies();
        exit = false;
        if (currencies != null) {
            while (!exit) {
                requestConversion(sc);
            }
        }
    }

    private static void requestConversion(Scanner sc) {
        String altCurrency;
        System.out.println();
        System.out.println("Type the currency you want to exchange or type X to exit: ");
        System.out.println();
        System.out.print("-> ");
        mainCurrency = sc.nextLine()
                .toUpperCase()
                .trim();
        if (mainCurrency.equals("X") || mainCurrency.equals("x")) {
            System.out.println();
            exit = true;
            return;
        }
        while (currencies.isSupported(mainCurrency)) {
            System.out.println("Yikes! I couldn't find " + mainCurrency);
            System.out.println("Please try again: ");
            System.out.print("-> ");
            mainCurrency = sc.nextLine()
                    .toUpperCase()
                    .trim();
        }
        Message_template.lines();
        System.out.println();
        System.out.println("You now need to type the currency you want to convert with " + mainCurrency + ":");
        System.out.println();
        System.out.print("-> ");
        altCurrency = sc.nextLine()
                .toUpperCase()
                .trim();
        while (currencies.isSupported(altCurrency) || altCurrency.equals(mainCurrency)) {
            if (altCurrency.equals(mainCurrency)) {
                System.out.println("Houston there's a problem!");
                System.out.println("You may not want to exchange the same currency are you?");
                System.out.println("You can try again: ");
                System.out.print("-> ");
                altCurrency = sc.nextLine()
                        .toUpperCase()
                        .trim();
            } else {
                System.out.println("Yikes! I couldn't find " + altCurrency);
                System.out.println("Please try again: ");
                System.out.print("-> ");
                altCurrency = sc.nextLine()
                        .toUpperCase()
                        .trim();
            }
        }
        Message_template.lines();
        boolean validNumber = false;
        boolean pairMsg = false;
        while (!validNumber) {
            try {
                if (!pairMsg) {
                    System.out.println();
                    System.out.println("Now pairing " + mainCurrency + " to " + altCurrency);
                    pairMsg = true;
                }
                System.out.println();
                System.out.println("Insert the amount of " + mainCurrency);
                System.out.print("$ ");
                amountMain = Double.valueOf(sc.nextLine());
                validNumber = true;
                Message_template.lines();
            } catch (NumberFormatException e) {
                System.out.println();
                Console.color("Please only numbers!!", Console.RED);
                Console.color("Example: 1250.75", Console.YELLOW);
                System.out.println();
                Message_template.lines();
            }
        }
        connectionAPI(altCurrency);

    }

    private static CurrencyDTO initConnection() {
        URI api_url = URI.create("https://v6.exchangerate-api.com/v6/" + api_key + "/latest/" + getCurrencyName());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(api_url)
                .build();
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CurrencyDTO.class);
        } catch (IOException e) {
            System.out.println("Error no response from server");
        } catch (IllegalArgumentException e) {
            System.out.println("Error empty currency?");
        } catch (InterruptedException e) {
            System.out.println("Error");
        } catch (NullPointerException e) {
            System.out.println("Couldn't get that currency or API Key is invalid");
        } catch (JsonSyntaxException e) {
            System.out.println("Invalid syntax on Json request");
        }
        return null;
    }

    private static SupportedCurrenciesDTO addCurrencies() {
        URI api_url = URI.create("https://v6.exchangerate-api.com/v6/" + api_key + "/latest/AED");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(api_url)
                .build();
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), SupportedCurrenciesDTO.class);
        } catch (IOException e) {
            System.out.println("Error no response from server");
        } catch (IllegalArgumentException e) {
            System.out.println("Error empty currency?");
        } catch (InterruptedException e) {
            System.out.println("Error");
        } catch (NullPointerException e) {
            System.out.println("Couldn't get that currency or API Key is invalid");
        } catch (JsonSyntaxException e) {
            System.out.println("Invalid syntax on JSON request");
        }
        return null;
    }

    private static void saveData(CurrencyDTO currency_dto, String altCurrency) {
        if (currency_dto != null) {
            Double amountAlt = currency_dto.conversion_rates().get(altCurrency);
            Double calculatedAmount = Calculator.conversion(amountMain, amountAlt);
            System.out.println();
            Console.color("Final conversion is $ " + calculatedAmount + " " + altCurrency, Console.GREEN);
            SavedConversion.createTable(mainCurrency, altCurrency, amountMain, calculatedAmount);
        }
    }

    private static void connectionAPI(String altCurrency) {
        saveData(getConnection(), altCurrency);
    }

    private static CurrencyDTO getConnection() {
        return initConnection();
    }

    public static String getCurrencyName() {
        return mainCurrency;
    }

    public static SupportedCurrenciesDTO currencies() {
        return currencies;
    }
}


