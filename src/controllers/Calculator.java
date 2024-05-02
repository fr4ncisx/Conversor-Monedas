package controllers;

import java.text.DecimalFormat;

public class Calculator {
    private static final DecimalFormat df = new DecimalFormat("##.##");

    public static Double conversion(Double c1, Double c2){
        Double calculate = c1 * c2;
        String formattedNumber = df.format(calculate);
        return Double.parseDouble(formattedNumber.replace(",","."));
    }
}
