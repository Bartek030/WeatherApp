package pl.bartlomiej_swies.model;

import com.google.gson.Gson;
import pl.bartlomiej_swies.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

public class OpenWeatherMapApiQuery {

    private CurrentWeatherData currentWeatherData;
    private DailyForecastData dailyForecastData;
    private String cityName;
    private String currentWeatherApiUrl;
    private String dailyWeatherApiUrl;

    public OpenWeatherMapApiQuery(String cityName) {
        this.cityName = cityName;
        this.currentWeatherApiUrl = "https://api.openweathermap.org/data/2.5/weather?"
                + "q=" + cityName
                + "&units=metric"
                + "&lang=pl"
                + "&appid=" + Config.getOpenWeatherMapApiKey();
        this.dailyWeatherApiUrl = "https://api.openweathermap.org/data/2.5/onecall?"
                + "lat=" +	this.getCurrentWeatherData().getCoord().getLat()
                + "&lon=" + this.getCurrentWeatherData().getCoord().getLon()
                + "&units=metric"
                + "&lang=pl"
                + "&exclude=current,minutely,hourly,alerts"
                + "&appid=" + Config.getOpenWeatherMapApiKey();
    }

    public CurrentWeatherData getCurrentWeatherData() {
        try {
            String jsonString = returnDataFromApi(currentWeatherApiUrl);
            currentWeatherData = new Gson().fromJson(jsonString, CurrentWeatherData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentWeatherData;
    }

    public DailyForecastData getDailyForecastData() {
        try {
            String jsonString = returnDataFromApi(dailyWeatherApiUrl);
            dailyForecastData = new Gson().fromJson(jsonString, DailyForecastData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dailyForecastData;
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
