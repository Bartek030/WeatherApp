package pl.bartlomiej_swies.controller;

import javafx.scene.layout.Pane;
import pl.bartlomiej_swies.model.OpenWeatherMapApiQuery;
import pl.bartlomiej_swies.view.ViewFactory;

public abstract class ForecastViewController extends BaseController {

    public ForecastViewController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    protected void setCurrentWeatherData(Pane pane, OpenWeatherMapApiQuery openWeatherMapApiQuery) {
        pane.getChildren().add(getViewFactory().getCurrentWeatherView(openWeatherMapApiQuery.getCurrentWeatherData()));
    }

    protected void setDailyWeatherForecast(Pane pane, OpenWeatherMapApiQuery openWeatherMapApiQuery) {
        int numberOfDays = openWeatherMapApiQuery.getDailyForecastData().getDaily().size();
        for(int i = 1; i < numberOfDays; i++) {
            pane.getChildren().add(getViewFactory().getDailyForecastView(openWeatherMapApiQuery.getDailyForecastData().getDaily().get(i)));
        }
    }
}
