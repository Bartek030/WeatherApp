package pl.bartlomiej_swies.model;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.bartlomiej_swies.model.weatherData.DailyForecast;

import java.net.URL;
import java.util.ResourceBundle;

public class OneDayDataForDailyForecast {

    private VBox weatherData = new VBox();
    private Label dayOfTheWeek = new Label();
    private Label date = new Label();
    private HBox windCondition = new HBox();
    private Label windFieldName = new Label();
    private ImageView windArrow = new ImageView();
    private Label windspeed = new Label();
   // private ImageView weatherIcon = new ImageView();


    public OneDayDataForDailyForecast(DailyForecast dailyForecast) {
        dayOfTheWeek.setText("wtorek");
        date = new Label("05-07-2020");
        windFieldName = new Label("wiatr");
        windArrow = new ImageView();
        windspeed = new Label("5,55 m/s");
        setWeatherWindImage();
        windCondition.getChildren().addAll(windFieldName, windArrow, windspeed);
        weatherData.getChildren().addAll(dayOfTheWeek, date, windCondition);
    }

    private void setWeatherWindImage() {
        URL url = getClass().getResource("/view/img/arrow.png");
        Image image = new Image(String.valueOf(url));
        this.windArrow.setImage(image);
        this.windArrow.setRotate(160);
    }

    public VBox getWeatherData() {
        return weatherData;
    }
}
