package pl.bartlomiej_swies.model;

import com.google.gson.Gson;
import pl.bartlomiej_swies.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

public class OpenWeatherMapApiQuery {

    CurrentWeatherData currentWeatherData;

    private String urlAsString = "https://api.openweathermap.org/data/2.5/weather?"
            + "q=gorlice"
            + "&units=metric"
            + "&lang=pl"
            + "&appid=" + Config.getOpenWeatherMapApiKey();

    public String returnConnectionResult() throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlAsString);
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }
        bufferedReader.close();
        return result.toString();
    }

    public CurrentWeatherData getCurrentWeatherData() {
        try {
            String jsonString = returnConnectionResult();
            currentWeatherData = new Gson().fromJson(jsonString, CurrentWeatherData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentWeatherData;
    }
}
