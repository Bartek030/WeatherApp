package pl.bartlomiej_swies.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DefaultOpenWeatherMapApiClient implements OpenWeatherMapApiClient {

    @Override
    public String returnDataFromApi(String stringForApiRequest) throws IOException {
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
