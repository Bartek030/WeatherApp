package pl.bartlomiej_swies.model.geolocation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.*;
import java.net.InetAddress;
import java.net.URL;

public class Geolocation {

    private InputStream databasePath = getClass().getResourceAsStream("/database/GeoLite2-City.mmdb");

    public  String getCityName() throws IOException, GeoIp2Exception {
        String ipAddress = getIpAddress();
            File database = streamToFile(databasePath);
            DatabaseReader databaseReader = new DatabaseReader.Builder(database).build();
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            CityResponse cityResponse = databaseReader.city(inetAddress);
            return cityResponse.getCity().getName();
    }

    private String getIpAddress() throws IOException {
        String ipAddress = "";
        URL url = new URL("http://checkip.amazonaws.com/");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        return bufferedReader.readLine();
    }

    private static File streamToFile(InputStream in) throws IOException {
        File tempFile = File.createTempFile("GeoLite2-City-temp", ".mmdb");
        tempFile.deleteOnExit();
        FileOutputStream out = new FileOutputStream(tempFile);
        in.transferTo(out);
        return tempFile;
    }
}
