package pl.bartlomiej_swies.model.geolocation;

import java.io.IOException;

public class GeolocationStub extends Geolocation {

    private String getIpAddress() throws IOException {
        return "185.25.121.171";
    }
}