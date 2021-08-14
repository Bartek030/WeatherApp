package pl.bartlomiej_swies.model.weatherData;

public class MainConditions {
    private final float temp;
    private final int pressure;
    private final int humidity;

    public MainConditions(float temp, int pressure, int humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public int getTemp() {
        return (int) temp;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
