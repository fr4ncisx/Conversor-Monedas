package controllers;

import template.Console;

public class FindByCountry {
    public static String formatText(String s) {
        String[] stringArray = s.toLowerCase().split("\\s");
        StringBuilder sb = new StringBuilder();
        for (String word : stringArray) {
            try {
                sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        sb.setLength(sb.length() - 1);
        return String.valueOf(sb);
    }

    public static void showSupported(String country) {
        country = formatText(country);
        String currencyCode = switch (country) {
            case "United Arab Emirates" -> "AED";
            case "Afghanistan" -> "AFN";
            case "Albania" -> "ALL";
            case "Armenia" -> "AMD";
            case "Netherlands Antilles" -> "ANG";
            case "Angola" -> "AOA";
            case "Argentina" -> "ARS";
            case "Australia" -> "AUD";
            case "Aruba" -> "AWG";
            case "Azerbaijan" -> "AZN";
            case "Bosnia and Herzegovina" -> "BAM";
            case "Barbados" -> "BBD";
            case "Bangladesh" -> "BDT";
            case "Bulgaria" -> "BGN";
            case "Bahrain" -> "BHD";
            case "Burundi" -> "BIF";
            case "Bermuda" -> "BMD";
            case "Brunei" -> "BND";
            case "Bolivia" -> "BOB";
            case "Brazil" -> "BRL";
            case "Bahamas" -> "BSD";
            case "Bhutan" -> "BTN";
            case "Botswana" -> "BWP";
            case "Belarus" -> "BYN";
            case "Belize" -> "BZD";
            case "Canada" -> "CAD";
            case "Democratic Republic of the Congo" -> "CDF";
            case "Switzerland" -> "CHF";
            case "Chile" -> "CLP";
            case "China" -> "CNY";
            case "Colombia" -> "COP";
            case "Costa Rica" -> "CRC";
            case "Cuba" -> "CUP";
            case "Cape Verde" -> "CVE";
            case "Czech Republic" -> "CZK";
            case "Djibouti" -> "DJF";
            case "Denmark" -> "DKK";
            case "Dominican Republic" -> "DOP";
            case "Algeria" -> "DZD";
            case "Egypt" -> "EGP";
            case "Eritrea" -> "ERN";
            case "Ethiopia" -> "ETB";
            case "European Union" -> "EUR";
            case "Fiji" -> "FJD";
            case "Falkland Islands" -> "FKP";
            case "Faroe Islands" -> "FOK";
            case "United Kingdom" -> "GBP";
            case "Georgia" -> "GEL";
            case "Guernsey" -> "GGP";
            case "Ghana" -> "GHS";
            case "Gibraltar" -> "GIP";
            case "The Gambia" -> "GMD";
            case "Guinea" -> "GNF";
            case "Guatemala" -> "GTQ";
            case "Guyana" -> "GYD";
            case "Hong Kong" -> "HKD";
            case "Honduras" -> "HNL";
            case "Croatia" -> "HRK";
            case "Haiti" -> "HTG";
            case "Hungary" -> "HUF";
            case "Indonesia" -> "IDR";
            case "Israel" -> "ILS";
            case "Isle of Man" -> "IMP";
            case "India" -> "INR";
            case "Iraq" -> "IQD";
            case "Iran" -> "IRR";
            case "Iceland" -> "ISK";
            case "Jersey" -> "JEP";
            case "Jamaica" -> "JMD";
            case "Jordan" -> "JOD";
            case "Japan" -> "JPY";
            case "Kenya" -> "KES";
            case "Kyrgyzstan" -> "KGS";
            case "Cambodia" -> "KHR";
            case "Kiribati" -> "KID";
            case "Comoros" -> "KMF";
            case "South Korea" -> "KRW";
            case "Kuwait" -> "KWD";
            case "Cayman Islands" -> "KYD";
            case "Kazakhstan" -> "KZT";
            case "Laos" -> "LAK";
            case "Lebanon" -> "LBP";
            case "Sri Lanka" -> "LKR";
            case "Liberia" -> "LRD";
            case "Lesotho" -> "LSL";
            case "Libya" -> "LYD";
            case "Morocco" -> "MAD";
            case "Moldova" -> "MDL";
            case "Madagascar" -> "MGA";
            case "North Macedonia" -> "MKD";
            case "Myanmar" -> "MMK";
            case "Mongolia" -> "MNT";
            case "Macau" -> "MOP";
            case "Mauritania" -> "MRU";
            case "Mauritius" -> "MUR";
            case "Maldives" -> "MVR";
            case "Malawi" -> "MWK";
            case "Mexico" -> "MXN";
            case "Malaysia" -> "MYR";
            case "Mozambique" -> "MZN";
            case "Namibia" -> "NAD";
            case "Nigeria" -> "NGN";
            case "Nicaragua" -> "NIO";
            case "Norway" -> "NOK";
            case "Nepal" -> "NPR";
            case "New Zealand" -> "NZD";
            case "Oman" -> "OMR";
            case "Panama" -> "PAB";
            case "Peru" -> "PEN";
            case "Papua New Guinea" -> "PGK";
            case "Philippines" -> "PHP";
            case "Pakistan" -> "PKR";
            case "Poland" -> "PLN";
            case "Paraguay" -> "PYG";
            case "Qatar" -> "QAR";
            case "Romania" -> "RON";
            case "Serbia" -> "RSD";
            case "Russia" -> "RUB";
            case "Rwanda" -> "RWF";
            case "Saudi Arabia" -> "SAR";
            case "Solomon Islands" -> "SBD";
            case "Seychelles" -> "SCR";
            case "Sudan" -> "SDG";
            case "Sweden" -> "SEK";
            case "Singapore" -> "SGD";
            case "Saint Helena" -> "SHP";
            case "Sierra Leone" -> "SLE";
            case "Somalia" -> "SOS";
            case "Suriname" -> "SRD";
            case "South Sudan" -> "SSP";
            case "São Tomé and Príncipe" -> "STN";
            case "Syria" -> "SYP";
            case "Eswatini" -> "SZL";
            case "Thailand" -> "THB";
            case "Tajikistan" -> "TJS";
            case "Turkmenistan" -> "TMT";
            case "Tunisia" -> "TND";
            case "Tonga" -> "TOP";
            case "Turkey" -> "TRY";
            case "Trinidad and Tobago" -> "TTD";
            case "Tuvalu" -> "TVD";
            case "Taiwan" -> "TWD";
            case "Tanzania" -> "TZS";
            case "Ukraine" -> "UAH";
            case "Uganda" -> "UGX";
            case "United States" -> "USD";
            case "Uruguay" -> "UYU";
            case "Uzbekistan" -> "UZS";
            case "Venezuela" -> "VES";
            case "Vietnam" -> "VND";
            case "Vanuatu" -> "VUV";
            case "Samoa" -> "WST";
            case "CEMAC" -> "XAF";
            case "Organisation of Eastern Caribbean States" -> "XCD";
            case "International Monetary Fund" -> "XDR";
            case "CFA" -> "XOF";
            case "Collectivités d'Outre-Mer" -> "XPF";
            case "Yemen" -> "YER";
            case "South Africa" -> "ZAR";
            case "Zambia" -> "ZMW";
            case "Zimbabwe" -> "ZWL";
            default -> "Invalid country name";
        };
        if (currencyCode.equals("Invalid country name")) {
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
            System.out.println();
            Console.color("The country '" + country + "' was not found", Console.RED);
            System.out.println();
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
            Console.color("Try Again? y/n", Console.PURPLE);
            System.out.println();
            System.out.print(" > ");
        } else {
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
            System.out.println();
            Console.color("The country '" + country + "' currency is " + Console.YELLOW + "'" + currencyCode + "'", Console.GREEN);
            System.out.println();
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
            Console.color("Try Again? y/n", Console.PURPLE);
            System.out.println();
            System.out.print(" > ");
        }
    }
}
