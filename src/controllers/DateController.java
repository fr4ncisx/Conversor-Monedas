package controllers;

import java.time.LocalDateTime;
import java.util.Date;

public class DateController {
    private static final LocalDateTime currentDate = LocalDateTime.now();

    private static String zeroMinutes() {
        if (currentDate.getMinute() < 9) {
            return "0" + String.valueOf(currentDate.getMinute());
        } else {
            return String.valueOf(currentDate.getMinute());
        }
    }

    public static String getTimestamp() {
        return "Time=" + currentDate.getHour() + ":"
                + zeroMinutes() +
                ", Date=" + currentDate.getDayOfMonth() +
                "/" + currentDate.getMonthValue()
                + "/" + currentDate.getYear();
    }
}
