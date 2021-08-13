package pl.bartlomiej_swies.controller;

import javafx.scene.layout.Pane;
import pl.bartlomiej_swies.model.CurrentWeatherData;
import pl.bartlomiej_swies.model.DailyForecastData;
import pl.bartlomiej_swies.model.OpenWeatherMapApiQuery;
import pl.bartlomiej_swies.view.ViewFactory;

import java.io.IOException;

public abstract class ForecastViewController extends BaseController {

    protected OpenWeatherMapApiQuery openWeatherMapApiQuery = new OpenWeatherMapApiQuery();
    protected CurrentWeatherData currentWeatherData;
    protected DailyForecastData dailyForecastData;

    public ForecastViewController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    protected void setWeatherData(Pane pane, String cityName) {
        try {
            currentWeatherData = openWeatherMapApiQuery.getCurrentWeatherData(cityName);
            dailyForecastData = openWeatherMapApiQuery.getDailyForecastData(currentWeatherData.getCoord().getLat(), currentWeatherData.getCoord().getLon());
            setCurrentWeatherData(pane, currentWeatherData);
            setDailyWeatherForecast(pane, dailyForecastData);
        } catch (IOException e) {
            e.printStackTrace();
            // POKAZ OKNO Z BLEDEM
        }
    }

    private void setCurrentWeatherData(Pane pane, CurrentWeatherData currentWeatherData) {
        pane.getChildren().add(viewFactory.getCurrentWeatherView(currentWeatherData));
    }

    private void setDailyWeatherForecast(Pane pane, DailyForecastData dailyForecastData) {
        int numberOfDays = dailyForecastData.getDaily().size();
        for(int i = 1; i < numberOfDays; i++) {
            pane.getChildren().add(viewFactory.getDailyForecastView(dailyForecastData.getDaily().get(i)));
        }
    }
}
