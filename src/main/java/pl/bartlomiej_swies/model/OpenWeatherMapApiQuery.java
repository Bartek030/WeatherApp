package pl.bartlomiej_swies.model;

import com.google.gson.Gson;
import pl.bartlomiej_swies.config.ApiRequestPrefixes;
import pl.bartlomiej_swies.config.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

public class OpenWeatherMapApiQuery {

    private final Gson gson = new Gson();

    public CurrentWeatherData getCurrentWeatherData(String cityName) throws IOException {

        String currentWeatherApiUrl = ApiRequestPrefixes.CURRENT_WEATHER_URL_PREFIX
                                    + ApiRequestPrefixes.CITY_NAME_PREFIX + cityName
                                    + ApiRequestPrefixes.UNITS_PREFIX + Config.DEFAULT_UNITS
                                    + ApiRequestPrefixes.LANGUAGE_PREFIX + Config.DEFAULT_LANGUAGE
                                    + ApiRequestPrefixes.API_KEY_PREFIX + Config.OPEN_WEATHER_MAP_API_KEY;

        String jsonString = returnDataFromApi(currentWeatherApiUrl);
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

        String jsonString = returnDataFromApi(dailyWeatherApiUrl);
        return gson.fromJson(jsonString, DailyForecastData.class);
    }

    private String returnDataFromApi(String stringForApiRequest) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(stringForApiRequest);
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }
        bufferedReader.close();
        return result.toString();
    }
}
