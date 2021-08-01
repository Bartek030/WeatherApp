package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import pl.bartlomiej_swies.model.OpenWeatherMapApiQuery;
import pl.bartlomiej_swies.view.ViewFactory;

public class NewCityForecastPanelController extends ForecastViewController {

    private OpenWeatherMapApiQuery openWeatherMapApiQuery;
    private String cityName;

    @FXML
    private HBox newCityForecastHBox;

    @FXML
    private TextField newCityTextField;

    public NewCityForecastPanelController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
        cityName = "";
    }

    @FXML
    void showNewCityForecastButton() {
        if ((!cityName.equals(newCityTextField.getText())) && !newCityTextField.getText().isEmpty()) {
            newCityForecastHBox.getChildren().clear();
            cityName = newCityTextField.getText();
            openWeatherMapApiQuery = new OpenWeatherMapApiQuery(cityName);
            setCurrentWeatherData(newCityForecastHBox, openWeatherMapApiQuery);
            setDailyWeatherForecast(newCityForecastHBox, openWeatherMapApiQuery);
        }
    }
}