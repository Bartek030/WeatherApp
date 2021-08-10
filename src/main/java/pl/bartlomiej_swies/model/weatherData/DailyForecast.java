package pl.bartlomiej_swies.model.weatherData;

import java.util.List;

public class DailyForecast {

    private final long dt;
    private final DailyTemperature temp;
    private final int pressure;
    private final int humidity;
    private final float wind_speed;
    private final int wind_deg;
    private final List<Weather> weather;

    public DailyForecast(long dt, DailyTemperature temp, int pressure, int humidity, float wind_speed, int wind_deg, List<Weather> weather) {
        this.dt = dt;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
        this.wind_deg = wind_deg;
        this.weather = weather;
    }

    public long getDt() {
        return dt;
    }

    public DailyTemperature getTemp() {
        return temp;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public int getWind_deg() {
        return wind_deg;
    }

    public List<Weather> getWeather() {
        return weather;
    }
}
