package models;

public record CurrencyHistory(String currencyFrom, String currencyTo, Double amountMain, Double amountConverted,
                              String time) {
    @Override
    public String toString() {
        return "Operation=" + currencyFrom + " to " + currencyTo +
                ", Amount='" + amountMain + " " + currencyFrom + "', " + "Conversion='"
                + amountConverted + " " + currencyTo + "', " + time;
    }
}
