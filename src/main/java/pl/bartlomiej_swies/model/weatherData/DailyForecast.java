package pl.bartlomiej_swies.model.weatherData;

import java.util.List;

public class DailyForecast {

     private List<DailyTemperature> temp;
     private int pressure;
     private int humidity;
     private float wind_speed;
     private float wind_deg;
     private List<Weather> weather;

    public DailyForecast(List<DailyTemperature> temp, int pressure, int humidity, float wind_speed, float wind_deg, List<Weather> weather) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
        this.wind_deg = wind_deg;
        this.weather = weather;
    }

    public List<DailyTemperature> getTemp() {
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

    public float getWind_deg() {
        return wind_deg;
    }

    public List<Weather> getWeather() {
        return weather;
    }
}
