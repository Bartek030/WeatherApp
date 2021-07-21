package pl.bartlomiej_swies.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.bartlomiej_swies.WeatherApplication;
import pl.bartlomiej_swies.controller.BaseController;
import pl.bartlomiej_swies.controller.MainWindowController;

import java.io.IOException;

public class ViewFactory {

    private WeatherApplication weatherApplication;

    public ViewFactory(WeatherApplication weatherApplication) {
        this.weatherApplication = weatherApplication;
    }

    public void showMainWindow() {
        BaseController controller = new MainWindowController(weatherApplication, this, "/view/MainWindow.fxml");
        initializeStage(controller);
    }

    private void initializeStage(BaseController baseController) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
