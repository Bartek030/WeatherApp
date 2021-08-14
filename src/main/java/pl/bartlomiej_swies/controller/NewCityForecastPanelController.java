package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import pl.bartlomiej_swies.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class NewCityForecastPanelController extends ForecastViewController implements Initializable {

    private String cityName = "";

    @FXML
    private HBox newCityForecastHBox;

    @FXML
    private TextField newCityTextField;

    public NewCityForecastPanelController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newCityForecastHBox.setAlignment(Pos.TOP_CENTER);
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