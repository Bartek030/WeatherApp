package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.bartlomiej_swies.model.OpenWeatherMapApiQuery;
import pl.bartlomiej_swies.view.ViewFactory;


public class NewCityForecastPanelController extends BaseController {

    OpenWeatherMapApiQuery openWeatherMapApiQuery;

    @FXML
    private HBox newCiteForecastHBox;

    @FXML
    private TextField newCityTextField;

    public NewCityForecastPanelController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void showNewCityForecastButton() {
        String cityName = newCityTextField.getText();
        openWeatherMapApiQuery = new OpenWeatherMapApiQuery(cityName);
        setCurrentWeatherData();
        setDailyWeatherForecast();
    }

    private void setCurrentWeatherData() {
        newCiteForecastHBox.getChildren().add(getViewFactory().getCurrentWeatherView(openWeatherMapApiQuery.getCurrentWeatherData()));
    }

    private void setDailyWeatherForecast() {
        int numberOfDays = openWeatherMapApiQuery.getDailyForecastData().getDaily().size();

        for(int i = 0; i < numberOfDays; i++) {
            newCiteForecastHBox.getChildren().add(getViewFactory().getDailyForecastView(openWeatherMapApiQuery.getDailyForecastData().getDaily().get(i)));
        }
    }
}
