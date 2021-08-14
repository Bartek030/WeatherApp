package pl.bartlomiej_swies.model.weatherData;

public class Coordinates {
    private final double lon;
    private final double lat;

    public Coordinates(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
