package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.bartlomiej_swies.model.OpenWeatherMapApiQuery;
import pl.bartlomiej_swies.model.geolocation.Geolocation;
import pl.bartlomiej_swies.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    private OpenWeatherMapApiQuery openWeatherMapApi;
    private String currentCityName;

    @FXML
    private VBox currentWeatherVBox;

    @FXML
    private HBox weeklyWeatherHBox;

    @FXML
    private Label userCurrentLocationLabel;

    @FXML
    private Label errorLabel;

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
        currentCityName = new Geolocation().getCityName();
        openWeatherMapApi = new OpenWeatherMapApiQuery(currentCityName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCurrentWeatherData();
        setDailyWeatherForecast();
        userCurrentLocationLabel.setText(currentCityName);
    }

    private void setCurrentWeatherData() {
        currentWeatherVBox.getChildren().add(getViewFactory().getCurrentWeatherView(openWeatherMapApi.getCurrentWeatherData()));
    }

    private void setDailyWeatherForecast() {
        int numberOfDays = openWeatherMapApi.getDailyForecastData().getDaily().size();

        for(int i = 0; i < numberOfDays; i++) {
            weeklyWeatherHBox.getChildren().add(getViewFactory().getDailyForecastView(openWeatherMapApi.getDailyForecastData().getDaily().get(i)));
        }
    }


}
