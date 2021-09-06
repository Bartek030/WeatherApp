package pl.bartlomiej_swies;

import javafx.application.Application;
import javafx.stage.Stage;

import pl.bartlomiej_swies.config.MessageLabels;
import pl.bartlomiej_swies.model.auxiliaryMethods.Connection;
import pl.bartlomiej_swies.model.auxiliaryMethods.UserConnection;
import pl.bartlomiej_swies.view.ViewFactory;

public class Launcher extends Application {

    Connection userConnection = new UserConnection();

    @Override
    public void start(Stage stage) {
        ViewFactory viewFactory = new ViewFactory();
        if (userConnection.isUserConnectedToTheInternet()) {
            viewFactory.showMainWindow();
        } else {
            viewFactory.showMessageWindow(MessageLabels.NO_INTERNET_CONNECTION);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}