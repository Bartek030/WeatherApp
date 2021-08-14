package pl.bartlomiej_swies.model.auxiliaryMethods;

import java.util.Locale;

public class StringMethods {

    public static String capitalizeFirstLetter(String str) {

        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
