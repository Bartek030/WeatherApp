package pl.bartlomiej_swies.model.auxiliaryMethods;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateMethods {

    public static String getDayOfTheWeekFromNumberOfMillis(long milliseconds) {
        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(milliseconds), ZoneId.systemDefault());
        return date.format(DateTimeFormatter.ofPattern("EEEE", Locale.forLanguageTag("pl-PL")));
    }

    public static String getDateFromNumberOfMillis(long milliseconds) {
        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(milliseconds), ZoneId.systemDefault());
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
