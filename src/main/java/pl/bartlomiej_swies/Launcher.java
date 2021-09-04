package pl.bartlomiej_swies;

import javafx.application.Application;
import javafx.stage.Stage;

import pl.bartlomiej_swies.config.MessageLabels;
import pl.bartlomiej_swies.view.ViewFactory;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {

        ViewFactory viewFactory = new ViewFactory();
        if (Launcher.isUserConnectedToTheInternet()) {
            viewFactory.showMainWindow();
        } else {
            viewFactory.showMessageWindow(MessageLabels.NO_INTERNET_CONNECTION);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static boolean isUserConnectedToTheInternet() {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}