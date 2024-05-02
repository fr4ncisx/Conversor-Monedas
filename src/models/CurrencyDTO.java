package models;

import java.util.Map;

public record CurrencyDTO(Map<String, Double> conversion_rates) {

}
