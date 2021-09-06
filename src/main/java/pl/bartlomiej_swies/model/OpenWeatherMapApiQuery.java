package pl.bartlomiej_swies.model;

import com.google.gson.Gson;
import pl.bartlomiej_swies.config.ApiRequestPrefixes;
import pl.bartlomiej_swies.config.Config;

import java.io.IOException;

public class OpenWeatherMapApiQuery {

    private final Gson gson = new Gson();
    private final OpenWeatherMapApiClient client;

    public OpenWeatherMapApiQuery(OpenWeatherMapApiClient client) {
        this.client = client;
    }

    public CurrentWeatherData getCurrentWeatherData(String cityName) throws IOException {

        String currentWeatherApiUrl = ApiRequestPrefixes.CURRENT_WEATHER_URL_PREFIX
                                    + ApiRequestPrefixes.CITY_NAME_PREFIX + cityName
                                    + ApiRequestPrefixes.UNITS_PREFIX + Config.DEFAULT_UNITS
                                    + ApiRequestPrefixes.LANGUAGE_PREFIX + Config.DEFAULT_LANGUAGE
                                    + ApiRequestPrefixes.API_KEY_PREFIX + Config.OPEN_WEATHER_MAP_API_KEY;

        String jsonString = client.returnDataFromApi(currentWeatherApiUrl);
        return gson.fromJson(jsonString, CurrentWeatherData.class);
    }

    public DailyForecastData getDailyForecastData(double lat, double lon) throws IOException {

        String dailyWeatherApiUrl =   ApiRequestPrefixes.DAILY_FORECAST_URL_PREFIX
                                    + ApiRequestPrefixes.LATITUDE_PREFIX +	lat
                                    + ApiRequestPrefixes.LONGITUDE_PREFIX + lon
                                    + ApiRequestPrefixes.UNITS_PREFIX + Config.DEFAULT_UNITS
                                    + ApiRequestPrefixes.LANGUAGE_PREFIX + Config.DEFAULT_LANGUAGE
                                    + ApiRequestPrefixes.EXCLUDED_ELEMENTS
                                    + ApiRequestPrefixes.API_KEY_PREFIX + Config.OPEN_WEATHER_MAP_API_KEY;

        String jsonString = client.returnDataFromApi(dailyWeatherApiUrl);
        return gson.fromJson(jsonString, DailyForecastData.class);
    }
}
