package pl.bartlomiej_swies.model.geolocation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import pl.bartlomiej_swies.config.Config;
import pl.bartlomiej_swies.model.auxiliaryMethods.Connection;

import java.io.*;
import java.net.InetAddress;

public class Geolocation implements GeolocationProvider {

    private final InputStream databasePath = getClass().getResourceAsStream(Config.GEOLOCATION_DATABASE_PATH);
    private Connection userConnection;

    public Geolocation(Connection userConnection) {
        this.userConnection = userConnection;
    }

    public String getCityName() throws IOException, GeoIp2Exception {
        String ipAddress = userConnection.getIpAddress();
        File database = streamToFile(databasePath);
        DatabaseReader databaseReader = new DatabaseReader.Builder(database).build();
        InetAddress inetAddress = InetAddress.getByName(ipAddress);
        CityResponse cityResponse = databaseReader.city(inetAddress);
        return cityResponse.getCity().getName();
    }

    private static File streamToFile(InputStream in) throws IOException {
        File tempFile = File.createTempFile(Config.GEOLOCATION_DATABASE_TEMP_FILE_PREFIX, Config.GEOLOCATION_DATABASE_TEMP_FILE_SUFFIX);
        tempFile.deleteOnExit();
        FileOutputStream out = new FileOutputStream(tempFile);
        in.transferTo(out);
        return tempFile;
    }
}
