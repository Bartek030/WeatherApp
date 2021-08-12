package pl.bartlomiej_swies.config;

public class ApiRequestPrefixes {

    public static final String CURRENT_WEATHER_URL_PREFIX = "https://api.openweathermap.org/data/2.5/weather?";
    public static final String DAILY_FORECAST_URL_PREFIX = "https://api.openweathermap.org/data/2.5/onecall?";
    public static final String CITY_NAME_PREFIX = "q=";
    public static final String LATITUDE_PREFIX = "lat=";
    public static final String LONGITUDE_PREFIX = "&lon=";
    public static final String UNITS_PREFIX = "&units=";
    public static final String LANGUAGE_PREFIX = "&lang=";
    public static final String API_KEY_PREFIX = "&appid=";
    public static final String EXCLUDED_ELEMENTS = "&exclude=current,minutely,hourly,alerts";
}
