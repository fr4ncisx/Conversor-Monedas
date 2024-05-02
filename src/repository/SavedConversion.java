package repository;

import controllers.DateController;
import models.CurrencyHistory;
import template.Console;
import template.Message_template;

import java.util.ArrayList;
import java.util.List;

public class SavedConversion {
    private static final List<CurrencyHistory> dateHistory = new ArrayList<>();

    public static void createTable(String firstCurrency, String secondCurrency, Double main, Double converted) {
        String time = DateController.getTimestamp();
        CurrencyHistory history = new CurrencyHistory(firstCurrency, secondCurrency, main, converted, time);
        dateHistory.add(history);
    }
    public static void checkTable() {
        if(isEmpty()){
            Console.color("The history database is currently empty", Console.RED);
            System.out.println();
            return;
        }
        for (CurrencyHistory s : dateHistory) {
            Console.color(String.valueOf(s), Console.YELLOW);
        }
        System.out.println();
    }
    public static boolean isEmpty() {
        return dateHistory.isEmpty();
    }
}
