module pl.bartlomiej_swies {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens pl.bartlomiej_swies;
    opens pl.bartlomiej_swies.view;
    opens pl.bartlomiej_swies.controller;
    opens pl.bartlomiej_swies.model;
}