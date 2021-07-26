package pl.bartlomiej_swies.model.weatherData;

public class MainConditions {
    private float temp;
    private int pressure;
    private int humidity;

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
