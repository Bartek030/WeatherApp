package pl.bartlomiej_swies.model.weatherData;

public class DailyTemperature {

    private final float day;
    private final float night;

    public DailyTemperature(float day, float night) {
        this.day = day;
        this.night = night;
    }

    public int getNight() {
        return (int) night;
    }

    public int getDay() {
        return (int) day;
    }

}
