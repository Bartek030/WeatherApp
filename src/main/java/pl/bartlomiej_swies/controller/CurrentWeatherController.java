package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.bartlomiej_swies.config.LabelsDescription;
import pl.bartlomiej_swies.model.CurrentWeatherData;
import pl.bartlomiej_swies.model.auxiliaryMethods.ImageResolver;
import pl.bartlomiej_swies.model.auxiliaryMethods.StringMethods;
import pl.bartlomiej_swies.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrentWeatherController extends BaseController implements Initializable {

    private final CurrentWeatherData currentWeatherData;

    @FXML
    private Label cityNameLabel;

    @FXML
    private ImageView currentWeatherImage;

    @FXML
    private Label currentWeatherTemperature;

    @FXML
    private Label currentWeatherDescription;

    @FXML
    private Label currentWindLabel;

    @FXML
    private ImageView currentWindImage;

    @FXML
    private Label currentWeatherPressure;

    @FXML
    private Label currentWeatherHumidity;

    public CurrentWeatherController(ViewFactory viewFactory, String fxmlName, CurrentWeatherData currentWeatherData) {
        super(viewFactory, fxmlName);
        this.currentWeatherData = currentWeatherData;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCityNameLabel();
        setCurrentWeatherImage();
        setCurrentWeatherTemperatureLabel();
        setCurrentWeatherDescriptionLabel();
        setCurrentWindLabel();
        setCurrentWindImage();
        setCurrentWeatherPressureLabel();
        setCurrentWeatherHumidityLabel();
    }

    private void setCityNameLabel() {
        String cityName = currentWeatherData.getName().toUpperCase();
        cityNameLabel.setText(cityName);
    }

    private void setCurrentWeatherImage() {
        Image image = ImageResolver.getWeatherIcon(currentWeatherData.getWeather().get(0).getIcon());
        currentWeatherImage.setImage(image);
    }

    private void setCurrentWeatherTemperatureLabel() {
        String temperature = currentWeatherData.getMain().getTemp() + LabelsDescription.TEMPERATURE_UNIT;
        currentWeatherTemperature.setText(temperature);
    }

    private void setCurrentWeatherDescriptionLabel() {
        String description = StringMethods.capitalizeFirstLetter(currentWeatherData.getWeather().get(0).getDescription());
        currentWeatherDescription.setText(description);
    }

    private void setCurrentWindLabel() {
        String windLabel = LabelsDescription.WIND_LABEL + currentWeatherData.getWind().getSpeed() + LabelsDescription.WIND_UNIT;
        currentWindLabel.setText(windLabel);
    }

    private void setCurrentWindImage() {
        URL url = getClass().getResource(ImageResolver.ARROW_IMAGE_PATH);
        Image image = new Image(String.valueOf(url));
        int windDeg = currentWeatherData.getWind().getDeg();

        currentWindImage.setImage(image);
        currentWindImage.setRotate(windDeg);
    }

    private void setCurrentWeatherPressureLabel() {
        String pressureLabel = LabelsDescription.PRESSURE_LABEL + currentWeatherData.getMain().getPressure() + LabelsDescription.PRESSURE_UNIT;
        currentWeatherPressure.setText(pressureLabel);
    }

    private void setCurrentWeatherHumidityLabel() {
        String humidityLabel = LabelsDescription.HUMIDITY_LABEL + currentWeatherData.getMain().getHumidity() + LabelsDescription.HUMIDITY_UNIT;
        currentWeatherHumidity.setText(humidityLabel);
    }
}
