package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.bartlomiej_swies.model.weatherData.DailyForecast;
import pl.bartlomiej_swies.view.ViewFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DailyForecastController extends BaseController implements Initializable {

    DailyForecast dailyForecast;

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

        dayOfTheWeekLabel.setText(dayOfTheWeek);
        dateLabel.setText(dateInStringFormat);
    }

    private void setWindSpeed() {
        windLabel.setText("Wiatr " + dailyForecast.getWind_speed() + " m/s");
    }

    private void setWindImage() {
        URL url = getClass().getResource("/view/img/arrow.png");
        Image image = new Image(String.valueOf(url));
        windImage.setImage(image);
    }

    private void setWeatherImage() {
        String imageIcon = dailyForecast.getWeather().get(0).getIcon();
        String imageSource = "http://openweathermap.org/img/wn/" + imageIcon + "@2x.png";
        weatherImage.setImage(new Image(imageSource));
    }

    private void setTemperatureLabel() {
        temperatureLabel.setText("Temp.: " + dailyForecast.getTemp().getDay() + " (" + dailyForecast.getTemp().getNight() + ") \u00B0C");
    }

    private void setPressureLabel() {
        pressureLabel.setText("Ciśnienie: " + dailyForecast.getPressure() + " hPa");
    }

    private void setHumidityLabel() {
        humidityLabel.setText("Wilgotność: " + dailyForecast.getHumidity() + " %");
    }
}
