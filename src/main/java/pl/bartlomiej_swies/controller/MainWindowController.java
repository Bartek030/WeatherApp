package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    private OpenWeatherMapApiQuery openWeatherMapApiQuery;
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
    private Label errorLabel;

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
        currentCityName = new Geolocation().getCityName();
        openWeatherMapApiQuery = new OpenWeatherMapApiQuery(currentCityName);
        numberOfNewCityForecast = 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCurrentWeatherData();
        setDailyWeatherForecast();
        userCurrentLocationLabel.setText(currentCityName.toUpperCase());
    }

    private void setCurrentWeatherData() {
        currentWeatherVBox.getChildren().add(getViewFactory().getCurrentWeatherView(openWeatherMapApiQuery.getCurrentWeatherData()));
    }

    private void setDailyWeatherForecast() {
        int numberOfDays = openWeatherMapApiQuery.getDailyForecastData().getDaily().size();

        for(int i = 0; i < numberOfDays; i++) {
            weeklyWeatherHBox.getChildren().add(getViewFactory().getDailyForecastView(openWeatherMapApiQuery.getDailyForecastData().getDaily().get(i)));
        }
    }

    @FXML
    void addNewCityForecastButton() {
        if (numberOfNewCityForecast < 3) {
            int indexOfButtonsHBox = mainAppContainerVBox.getChildren().indexOf(ButtonsHBox);
            mainAppContainerVBox.getChildren().add(indexOfButtonsHBox, getViewFactory().getNewCityForecastPanel());
            numberOfNewCityForecast++;
        }
    }

    @FXML
    void deleteLastForecastButton() {
        if(numberOfNewCityForecast > 0) {
            int indexOfButtonsHBox = mainAppContainerVBox.getChildren().indexOf(ButtonsHBox);
            mainAppContainerVBox.getChildren().remove(indexOfButtonsHBox - 1);
        }
    }
}
