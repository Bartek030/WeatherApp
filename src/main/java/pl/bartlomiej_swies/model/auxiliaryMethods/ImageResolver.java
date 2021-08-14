package pl.bartlomiej_swies.model.auxiliaryMethods;

import javafx.scene.image.Image;

public class ImageResolver {

    public static final String ARROW_IMAGE_PATH = "/view/img/arrow.png";

    public static Image getWeatherIcon(String imageIcon) {
        String imageSource = "http://openweathermap.org/img/wn/" + imageIcon + "@2x.png";
        return new Image(imageSource);
    }
}
