package pl.bartlomiej_swies.model;

import com.google.gson.Gson;
import pl.bartlomiej_swies.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

public class OpenWeatherMapApiQuery {

    private final Gson gson = new Gson();

    public CurrentWeatherData getCurrentWeatherData(String cityName) {
        try {
            String currentWeatherApiUrl = "https://api.openweathermap.org/data/2.5/weather?"
                    + "q=" + cityName
                    + "&units=metric"
                    + "&lang=pl"
                    + "&appid=" + Config.OPEN_WEATHER_MAP_API_KEY;

            String jsonString = returnDataFromApi(currentWeatherApiUrl);
            return gson.fromJson(jsonString, CurrentWeatherData.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public DailyForecastData getDailyForecastData(double lat, double lon) {
        try {
            String dailyWeatherApiUrl = "https://api.openweathermap.org/data/2.5/onecall?"
                    + "lat=" +	lat
                    + "&lon=" + lon
                    + "&units=metric"
                    + "&lang=pl"
                    + "&exclude=current,minutely,hourly,alerts"
                    + "&appid=" + Config.OPEN_WEATHER_MAP_API_KEY;

            String jsonString = returnDataFromApi(dailyWeatherApiUrl);
            return gson.fromJson(jsonString, DailyForecastData.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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
