package pl.bartlomiej_swies.controller;

import pl.bartlomiej_swies.WeatherApplication;
import pl.bartlomiej_swies.view.ViewFactory;

public class MainWindowController extends BaseController {
    public MainWindowController(WeatherApplication weatherApplication, ViewFactory viewFactory, String fxmlName) {
        super(weatherApplication, viewFactory, fxmlName);
    }
}
