package pl.bartlomiej_swies.model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import pl.bartlomiej_swies.model.weatherData.DailyForecast;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OneDayDataForDailyForecast {

    private DailyForecast dailyForecast;

    private VBox weatherData = new VBox();
    private Label dayOfTheWeek;
    private Label dateOfTheDay;
    private HBox windCondition = new HBox();
    private Label windFieldName = new Label("wiatr: ");
    private ImageView windArrow = new ImageView(getWeatherWindImage());
    private Label windspeed;
    private ImageView weatherIcon;

    public OneDayDataForDailyForecast(DailyForecast dailyForecast) {
        this.dailyForecast = dailyForecast;
        setDateInfo();
        setWindConditions();
        setWeatherIcon();
        windCondition.getChildren().addAll(windFieldName, windspeed, windArrow);
        windCondition.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        weatherData.getChildren().addAll(dayOfTheWeek, dateOfTheDay, windCondition, weatherIcon);
        weatherData.setPrefSize(120, Region.USE_COMPUTED_SIZE);
        weatherData.setAlignment(Pos.CENTER);
    }

    private void setDateInfo() {
        Date date = new Date(dailyForecast.getDt() * 1000);
        String dzientygodnia = new SimpleDateFormat("EEEE").format(date);
        String dateInStringFormat = new SimpleDateFormat("dd-MM-YYYY").format(date);

        dayOfTheWeek = new Label(dzientygodnia);
        dateOfTheDay = new Label(dateInStringFormat);
    }

    private void setWindConditions() {
        windspeed = new Label(dailyForecast.getWind_speed() + " m/s");
        windArrow.setRotate(dailyForecast.getWind_deg());
        windArrow.setFitWidth(20);
        windArrow.setFitHeight(20);
    }

    private void setWeatherIcon() {
        String imageIcon = dailyForecast.getWeather().get(0).getIcon();
        String imageSource = "http://openweathermap.org/img/wn/" + imageIcon + "@2x.png";
        weatherIcon = new ImageView(new Image(imageSource));
    }

    private Image getWeatherWindImage() {
        URL url = getClass().getResource("/view/img/arrow.png");
        Image image = new Image(String.valueOf(url));
        return image;
    }

    public VBox getWeatherData() {
        return weatherData;
    }
}
