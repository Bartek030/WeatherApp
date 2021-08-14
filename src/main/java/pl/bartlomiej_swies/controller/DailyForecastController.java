package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.bartlomiej_swies.config.LabelsDescription;
import pl.bartlomiej_swies.model.auxiliaryMethods.ImageResolver;
import pl.bartlomiej_swies.model.auxiliaryMethods.StringMethods;
import pl.bartlomiej_swies.model.weatherData.DailyForecast;
import pl.bartlomiej_swies.view.ViewFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DailyForecastController extends BaseController implements Initializable {

    private final DailyForecast dailyForecast;

    @FXML
    private Label dayOfTheWeekLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label windLabel;

    @FXML
    private ImageView windImage;

    @FXML
    private ImageView weatherImage;

    @FXML
    private Label temperatureLabel;

    @FXML
    private Label pressureLabel;

    @FXML
    private Label humidityLabel;

    public DailyForecastController(ViewFactory viewFactory, String fxmlName, DailyForecast dailyForecast) {
        super(viewFactory, fxmlName);
        this.dailyForecast = dailyForecast;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDateAndDayOfTheWeekLabels();
        setWindSpeed();
        setWindImage();
        setWeatherImage();
        setTemperatureLabel();
        setPressureLabel();
        setHumidityLabel();
    }

    private void setDateAndDayOfTheWeekLabels() {
        Date date = new Date(dailyForecast.getDt() * 1000);
        String dayOfTheWeek = new SimpleDateFormat("EEEE").format(date);
        String dateInStringFormat = new SimpleDateFormat("dd-MM-YYYY").format(date);

        dayOfTheWeekLabel.setText(StringMethods.capitalizeFirstLetter(dayOfTheWeek));
        dateLabel.setText(dateInStringFormat);
    }

    private void setWindSpeed() {
        String windSpeed = LabelsDescription.WIND_LABEL + dailyForecast.getWind_speed() + LabelsDescription.WIND_UNIT;
        windLabel.setText(windSpeed);
    }

    private void setWindImage() {
        URL url = getClass().getResource(ImageResolver.ARROW_IMAGE_PATH);
        Image image = new Image(String.valueOf(url));
        int windDeg = dailyForecast.getWind_deg();

        windImage.setImage(image);
        windImage.setRotate(windDeg);
    }

    private void setWeatherImage() {
        Image image = ImageResolver.getWeatherIcon(dailyForecast.getWeather().get(0).getIcon());
        weatherImage.setImage(image);
    }

    private void setTemperatureLabel() {
        String temperature = LabelsDescription.TEMPERATURE_LABEL + dailyForecast.getTemp().getDay()
                            + " (" + dailyForecast.getTemp().getNight() + ") " + LabelsDescription.TEMPERATURE_UNIT;
        temperatureLabel.setText(temperature);
    }

    private void setPressureLabel() {
        String pressure = LabelsDescription.PRESSURE_LABEL + dailyForecast.getPressure() + LabelsDescription.PRESSURE_UNIT;
        pressureLabel.setText(pressure);
    }

    private void setHumidityLabel() {
        String humidity = LabelsDescription.HUMIDITY_LABEL + dailyForecast.getHumidity() + LabelsDescription.HUMIDITY_UNIT;
        humidityLabel.setText(humidity);
    }
}
