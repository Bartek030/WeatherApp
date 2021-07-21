package pl.bartlomiej_swies.controller;

import pl.bartlomiej_swies.WeatherApplication;
import pl.bartlomiej_swies.view.ViewFactory;

public abstract class BaseController {

    private WeatherApplication weatherApplication;
    private ViewFactory viewFactory;
    private String fxmlName;

    public BaseController(WeatherApplication weatherApplication, ViewFactory viewFactory, String fxmlName) {
        this.weatherApplication = weatherApplication;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}