package pl.bartlomiej_swies.model.geolocation;

import pl.bartlomiej_swies.model.OpenWeatherMapApiClient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenWeatherMapApiClientStubForCurrentWeatherData implements OpenWeatherMapApiClient {

    public String returnDataFromApi(String stringForApiRequest) throws IOException {
        String file = "src/test/resources/weather.json";
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
