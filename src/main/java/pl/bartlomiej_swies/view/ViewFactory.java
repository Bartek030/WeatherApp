package pl.bartlomiej_swies.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import pl.bartlomiej_swies.controller.*;
import pl.bartlomiej_swies.model.CurrentWeatherData;
import pl.bartlomiej_swies.model.weatherData.DailyForecast;

import java.io.IOException;

public class ViewFactory {

    public void showMainWindow() {
        BaseController controller = new MainWindowController(this, "/view/MainWindow.fxml");
        initializeStage(controller);
    }

    public void showMessageWindow() {
        BaseController controller = new MainWindowController(this, "/view/MessageWindow.fxml");
        initializeStage(controller);
    }

    public VBox getDailyForecastView(DailyForecast dailyForecast) {
        BaseController controller = new DailyForecastController(this, "/view/DailyForecast.fxml", dailyForecast);
        VBox dailyForeCastview = (VBox) getloadedFXML(controller);
        return dailyForeCastview;
    }

    public VBox getCurrentWeatherView(CurrentWeatherData currentWeatherData) {
        BaseController controller = new CurrentWeatherController(this, "/view/CurrentWeather.fxml", currentWeatherData);
        VBox currentWeatherView = (VBox) getloadedFXML(controller);
        return currentWeatherView;
    }

    public VBox getNewCityForecastPanel() {
        BaseController controller = new NewCityForecastPanelController(this, "/view/NewCityForecastPanel.fxml");
        VBox newCityForecastPanelView = (VBox) getloadedFXML(controller);
        return newCityForecastPanelView;
    }

    private Parent getloadedFXML(BaseController baseController) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return parent;
    }

    private void initializeStage(BaseController baseController) {
        Parent parent = getloadedFXML(baseController);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        Image icon = new Image(getClass().getResourceAsStream("/view/img/sun.png"));

        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("/view/css/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Prognoza Pogody");
        stage.getIcons().add(icon);
        stage.show();
    }
}
