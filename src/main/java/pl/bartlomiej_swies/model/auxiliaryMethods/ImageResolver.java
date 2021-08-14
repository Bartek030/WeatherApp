package pl.bartlomiej_swies.model.auxiliaryMethods;

import javafx.scene.image.Image;

public class ImageResolver {

    public static final String ARROW_IMAGE_PATH = "/view/img/arrow.png";
    public static final String MAIN_WINDOW_FXML_PATH = "/view/MainWindow.fxml";
    public static final String CURRENT_WEATHER_FXML_PATH = "/view/CurrentWeather.fxml";
    public static final String DAILY_FORECAST_FXML_PATH = "/view/DailyForecast.fxml";
    public static final String MESSAGE_WINDOW_FXML_PATH = "/view/MessageWindow.fxml";
    public static final String NEW_CITY_FORECAST_PANEL_FXML_PATH = "/view/NewCityForecastPanel.fxml";
    public static final String MAIN_APPLICATION_ICON_PATH = "/view/img/sun.png";

    public static Image getWeatherIcon(String imageIcon) {
        String imageSource = "http://openweathermap.org/img/wn/" + imageIcon + "@2x.png";
        return new Image(imageSource);
    }
}
