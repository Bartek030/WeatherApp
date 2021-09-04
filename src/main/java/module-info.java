module pl.bartlomiej_swies {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires geoip2;

    opens pl.bartlomiej_swies;
    opens pl.bartlomiej_swies.view;
    opens pl.bartlomiej_swies.controller;
    opens pl.bartlomiej_swies.model;
    opens pl.bartlomiej_swies.config;
    opens pl.bartlomiej_swies.model.auxiliaryMethods;
    opens pl.bartlomiej_swies.model.geolocation;
    opens pl.bartlomiej_swies.model.weatherData;
}