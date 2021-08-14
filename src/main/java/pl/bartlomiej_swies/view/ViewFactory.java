package pl.bartlomiej_swies.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import pl.bartlomiej_swies.config.Config;
import pl.bartlomiej_swies.config.MessageLabels;
import pl.bartlomiej_swies.controller.*;
import pl.bartlomiej_swies.model.CurrentWeatherData;
import pl.bartlomiej_swies.model.auxiliaryMethods.ImageResolver;
import pl.bartlomiej_swies.model.weatherData.DailyForecast;

import java.io.IOException;

public class ViewFactory {

    public void showMainWindow() {
        BaseController controller = new MainWindowController(this, ImageResolver.MAIN_WINDOW_FXML_PATH);
        initializeMainStage(controller);
    }

    public void showMessageWindow(String message) {
        BaseController controller = new MessageWindowController(this, ImageResolver.MESSAGE_WINDOW_FXML_PATH, message);
        initializeMessageStage(controller);
    }

    public VBox getDailyForecastView(DailyForecast dailyForecast) {
        BaseController controller = new DailyForecastController(this, ImageResolver.DAILY_FORECAST_FXML_PATH, dailyForecast);
        return (VBox) getLoadedFXML(controller);
    }

    public VBox getCurrentWeatherView(CurrentWeatherData currentWeatherData) {
        BaseController controller = new CurrentWeatherController(this, ImageResolver.CURRENT_WEATHER_FXML_PATH, currentWeatherData);
        return (VBox) getLoadedFXML(controller);
    }

    public VBox getNewCityForecastPanel() {
        BaseController controller = new NewCityForecastPanelController(this, ImageResolver.NEW_CITY_FORECAST_PANEL_FXML_PATH);
        return (VBox) getLoadedFXML(controller);
    }

    private void initializeMainStage(BaseController baseController) {
        Parent parent = getLoadedFXML(baseController);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();

        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource(Config.CSS_FILE_RESOURCE_PATH).toExternalForm());

        stage.setScene(scene);
        stage.setTitle(Config.APPLICATION_TITLE);
        stage.getIcons().add(getMainApplicationIcon());
        stage.show();
    }

    private void initializeMessageStage(BaseController baseController) {
        Parent parent = getLoadedFXML(baseController);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();

        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setTitle(MessageLabels.MESSAGE_WINDOW_TITLE);
        stage.setScene(scene);
        stage.getIcons().add(getMainApplicationIcon());
        stage.show();
    }

    private Parent getLoadedFXML(BaseController baseController) {
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

    private Image getMainApplicationIcon() {
        return new Image(getClass().getResourceAsStream(ImageResolver.MAIN_APPLICATION_ICON_PATH));
    }
}
