package pl.bartlomiej_swies.model.weatherData;

public class DailyTemperature {

    private float day;
    private float night;

    public DailyTemperature(float day, float night) {
        this.day = day;
        this.night = night;
    }

    public float getNight() {
        return night;
    }

    public float getDay() {
        return day;
    }

}
