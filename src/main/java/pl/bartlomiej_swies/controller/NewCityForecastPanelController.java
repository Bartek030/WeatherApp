package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import pl.bartlomiej_swies.view.ViewFactory;

public class NewCityForecastPanelController extends ForecastViewController {

    private String cityName = "";

    @FXML
    private HBox newCityForecastHBox;

    @FXML
    private TextField newCityTextField;

    public NewCityForecastPanelController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void showNewCityForecastButton() {
        if ((!cityName.equals(newCityTextField.getText())) && !newCityTextField.getText().isEmpty()) {
            newCityForecastHBox.getChildren().clear();
            cityName = newCityTextField.getText();
            setWeatherData(newCityForecastHBox, cityName);
        }
    }
}