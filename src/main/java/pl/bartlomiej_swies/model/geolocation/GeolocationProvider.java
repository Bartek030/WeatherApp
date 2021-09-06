package pl.bartlomiej_swies.model.geolocation;

import com.maxmind.geoip2.exception.GeoIp2Exception;

import java.io.IOException;

public interface GeolocationProvider {
    String getCityName() throws IOException, GeoIp2Exception;
}
