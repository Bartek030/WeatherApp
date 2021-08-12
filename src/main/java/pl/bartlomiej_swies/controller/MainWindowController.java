package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.bartlomiej_swies.Config;
import pl.bartlomiej_swies.model.geolocation.Geolocation;
import pl.bartlomiej_swies.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends ForecastViewController implements Initializable {

    private String currentCityName;
    private int numberOfNewCityForecast;

    @FXML
    private VBox mainAppContainerVBox;

    @FXML
    private VBox currentWeatherVBox;

    @FXML
    private HBox weeklyWeatherHBox;

    @FXML
    private HBox ButtonsHBox;

    @FXML
    private Label userCurrentLocationLabel;

    @FXML
    private Button addNewCityForecastButton;

    @FXML
    private Button deleteLastForecastButton;

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentCityName = getUserLocation();
        numberOfNewCityForecast = 0;
        setWeatherData(weeklyWeatherHBox, currentCityName);
    }

    private String getUserLocation() {
        String cityName = new Geolocation().getCityName();
        if(cityName != null) {
            return cityName;
        } else {
            cityName = Config.DEFAULT_CITY_NAME;
        }
        return cityName;
    }

    @FXML
    void addNewCityForecastButtonAction() {
        if (numberOfNewCityForecast < 3) {
            int indexOfButtonsHBox = mainAppContainerVBox.getChildren().indexOf(ButtonsHBox);
            mainAppContainerVBox.getChildren().add(indexOfButtonsHBox, getViewFactory().getNewCityForecastPanel());
            numberOfNewCityForecast++;
            deleteLastForecastButton.setDisable(false);
            if (numberOfNewCityForecast == 3) {
                addNewCityForecastButton.setDisable(true);
            }
        }
    }

    @FXML
    void deleteLastForecastButtonAction() {
        if(numberOfNewCityForecast > 0) {
            int indexOfButtonsHBox = mainAppContainerVBox.getChildren().indexOf(ButtonsHBox);
            mainAppContainerVBox.getChildren().remove(indexOfButtonsHBox - 1);
            numberOfNewCityForecast--;
            addNewCityForecastButton.setDisable(false);
            if(numberOfNewCityForecast == 0) {
                deleteLastForecastButton.setDisable(true);
            }
        }
    }
}
