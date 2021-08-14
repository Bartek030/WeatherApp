package pl.bartlomiej_swies.model;

import pl.bartlomiej_swies.model.weatherData.*;

import java.util.List;

public class CurrentWeatherData {

    private final Coordinates coord;
    private final List<Weather> weather;
    private final MainConditions main;
    private final WindConditions wind;
    private final String name;

    public CurrentWeatherData(Coordinates coord, List<Weather> weather, MainConditions main, WindConditions wind, String name) {
        this.coord = coord;
        this.weather = weather;
        this.main = main;
        this.wind = wind;
        this.name = name;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public MainConditions getMain() {
        return main;
    }

    public WindConditions getWind() {
        return wind;
    }

    public String getName() {
        return name;
    }
}
