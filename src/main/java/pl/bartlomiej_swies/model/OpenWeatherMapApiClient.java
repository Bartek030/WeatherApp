package pl.bartlomiej_swies.model;

import java.io.IOException;

public interface OpenWeatherMapApiClient {

    String returnDataFromApi(String stringForApiRequest) throws IOException;
}
