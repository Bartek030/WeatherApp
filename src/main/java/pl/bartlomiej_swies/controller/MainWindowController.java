package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.bartlomiej_swies.WeatherApplication;
import pl.bartlomiej_swies.model.OpenWeatherMapApi;
import pl.bartlomiej_swies.view.ViewFactory;

public class MainWindowController extends BaseController {

    OpenWeatherMapApi openWeatherMapApi = new OpenWeatherMapApi();

    @FXML
    private VBox fullWeatherForecastVBox;

    @FXML
    private HBox oneCityWeatherForecastHBox;

    @FXML
    private ImageView todayWeatherImage;

    public MainWindowController(WeatherApplication weatherApplication, ViewFactory viewFactory, String fxmlName) {
        super(weatherApplication, viewFactory, fxmlName);

    }

}
