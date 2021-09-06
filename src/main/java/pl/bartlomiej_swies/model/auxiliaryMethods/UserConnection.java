package pl.bartlomiej_swies.model.auxiliaryMethods;

import pl.bartlomiej_swies.config.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UserConnection implements Connection {

    public boolean isUserConnectedToTheInternet() {
        try {
            URL url = new URL(Config.CHECK_IP_URL_PATH);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public String getIpAddress() {
        try {
            URL url = new URL(Config.CHECK_IP_URL_PATH);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            return bufferedReader.readLine();
        } catch (IOException e) {
            return null;
        }
    }
}
