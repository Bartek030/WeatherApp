package pl.bartlomiej_swies.model.weatherData;

public class Weather {
    private final String description;
    private final String icon;

    public Weather(String main, String description, String icon) {
        this.description = description;
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
