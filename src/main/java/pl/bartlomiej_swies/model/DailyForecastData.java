package pl.bartlomiej_swies.model;

import pl.bartlomiej_swies.model.weatherData.DailyForecast;

import java.util.List;

public class DailyForecastData {

    private List<DailyForecast> daily;

    public DailyForecastData(List<DailyForecast> daily) {
        this.daily = daily;
    }

    public List<DailyForecast> getDaily() {
        return daily;
    }
}
