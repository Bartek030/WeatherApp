package pl.bartlomiej_swies.model.auxiliaryMethods;

public class StringMethods {

    public static String capitalizeFirstLetter(String str) {
        String capitalizedString = str.substring(0, 1).toUpperCase() + str.substring(1);
        return capitalizedString;
    }
}
