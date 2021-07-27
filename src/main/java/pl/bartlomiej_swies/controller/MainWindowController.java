package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import pl.bartlomiej_swies.model.OneDayDataForDailyForecast;
import pl.bartlomiej_swies.model.OpenWeatherMapApiQuery;
import pl.bartlomiej_swies.model.geolocation.Geolocation;
import pl.bartlomiej_swies.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    private OpenWeatherMapApiQuery openWeatherMapApi;
    private String currentCityName;

    @FXML
    private TextField enteredCityTextField;

    @FXML
    private ImageView currentWeatherImage;

    @FXML
    private Label currentWeatherTemperature;

    @FXML
    private Label currentWeatherDescription;

    @FXML
    private ImageView currentWeatherWindImage;

    @FXML
    private Label currentWeatherWindSpeed;

    @FXML
    private HBox weeklyWeatherHBox;

    @FXML
    private Label errorLabel;

    @FXML
    void showForecastButton() {

    }

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
        currentCityName = new Geolocation().getCityName();
        openWeatherMapApi = new OpenWeatherMapApiQuery(currentCityName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCurrentWeatherData();
        setDailyWeatherForecast();
    }

    private void setCurrentWeatherData() {
        setCurrentWeatherImage();
        setCurrentWeatherTemperature();
        setCurrentWeatherDescription();
        setWeatherWindImage();
        setCurrentWeatherWindSpeed();
    }

    private void setDailyWeatherForecast() {
        int numberOfDays = openWeatherMapApi.getDailyForecastData().getDaily().size();

        for(int i = 0; i < numberOfDays; i++) {
            OneDayDataForDailyForecast oneDayDataForDailyForecast = new OneDayDataForDailyForecast(openWeatherMapApi.getDailyForecastData().getDaily().get(i));
            weeklyWeatherHBox.getChildren().add(oneDayDataForDailyForecast.getWeatherData());
        }
    }

    private void setCurrentWeatherImage() {
        String imageIcon = openWeatherMapApi.getCurrentWeatherData().getWeather().get(0).getIcon();
        String imageSource = "http://openweathermap.org/img/wn/" + imageIcon + "@2x.png";
        currentWeatherImage.setImage(new Image(imageSource));
    }

    private void setCurrentWeatherTemperature() {
        String temperature = openWeatherMapApi.getCurrentWeatherData().getMain().getTemp() + "\u00B0C";
        currentWeatherTemperature.setText(temperature);
    }

    private void setCurrentWeatherDescription() {
        String description = openWeatherMapApi.getCurrentWeatherData().getWeather().get(0).getDescription();
        currentWeatherDescription.setText(description);
    }

    private void setWeatherWindImage() {
        URL url = getClass().getResource("/view/img/arrow.png");
        Image image = new Image(String.valueOf(url));
        currentWeatherWindImage.setImage(image);
        currentWeatherWindImage.setRotate(openWeatherMapApi.getCurrentWeatherData().getWind().getDeg());
    }

    private void setCurrentWeatherWindSpeed() {
        String windSpeed = openWeatherMapApi.getCurrentWeatherData().getWind().getSpeed() + " m/s";
        currentWeatherWindSpeed.setText(windSpeed);
    }
}
