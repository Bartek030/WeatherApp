package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.bartlomiej_swies.model.CurrentWeatherData;
import pl.bartlomiej_swies.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrentWeatherController extends BaseController implements Initializable {

    private CurrentWeatherData currentWeatherData;

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
        setCurrentWeatherImage();
        setCurrentWeatherTemperatureLabel();
        setCurrentWeatherDescriptionLabel();
        setCurrentWindLabel();
        setCurrentWindImage();
        setCurrentWeatherPressureLabel();
        setCurrentWeatherHumidityLabel();
    }

    private void setCurrentWeatherImage() {
        String imageIcon = currentWeatherData.getWeather().get(0).getIcon();
        String imageSource = "http://openweathermap.org/img/wn/" + imageIcon + "@2x.png";
        currentWeatherImage.setImage(new Image(imageSource));
    }

    private void setCurrentWeatherTemperatureLabel() {
        currentWeatherTemperature.setText(currentWeatherData.getMain().getTemp() + " \u00B0C");
    }

    private void setCurrentWeatherDescriptionLabel() {
        currentWeatherDescription.setText(currentWeatherData.getWeather().get(0).getDescription());
    }

    private void setCurrentWindLabel() {
        currentWindLabel.setText("Wiatr " + currentWeatherData.getWind().getSpeed() + " m/s");
    }

    private void setCurrentWindImage() {
        URL url = getClass().getResource("/view/img/arrow.png");
        Image image = new Image(String.valueOf(url));
        currentWindImage.setImage(image);
        currentWindImage.setRotate(currentWeatherData.getWind().getDeg());
    }

    private void setCurrentWeatherPressureLabel() {
        currentWeatherPressure.setText("Ciśnienie: " + currentWeatherData.getMain().getPressure() + " hPa");
    }

    private void setCurrentWeatherHumidityLabel() {
        currentWeatherHumidity.setText("Wilgotność: " + currentWeatherData.getMain().getHumidity() + " %");
    }
}
