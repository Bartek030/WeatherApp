package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import pl.bartlomiej_swies.model.OpenWeatherMapApiQuery;
import pl.bartlomiej_swies.view.ViewFactory;


public class NewCityForecastPanelController extends BaseController {

    private OpenWeatherMapApiQuery openWeatherMapApiQuery;
    private boolean isForecastShowed = false;
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
        if ((!isForecastShowed || !cityName.equals(newCityTextField.getText())) && !newCityTextField.getText().isEmpty()) {
            newCityForecastHBox.getChildren().clear();
            cityName = newCityTextField.getText();
            openWeatherMapApiQuery = new OpenWeatherMapApiQuery(cityName);
            setCurrentWeatherData();
            setDailyWeatherForecast();
            isForecastShowed = true;
        }
    }

    private void setCurrentWeatherData() {
        newCityForecastHBox.getChildren().add(getViewFactory().getCurrentWeatherView(openWeatherMapApiQuery.getCurrentWeatherData()));
    }

    private void setDailyWeatherForecast() {
        int numberOfDays = openWeatherMapApiQuery.getDailyForecastData().getDaily().size();

        for(int i = 0; i < numberOfDays; i++) {
            newCityForecastHBox.getChildren().add(getViewFactory().getDailyForecastView(openWeatherMapApiQuery.getDailyForecastData().getDaily().get(i)));
        }
    }
}
