package pl.bartlomiej_swies.model.geolocation;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class GeolocationStubTest {

    @Test
    void shouldReturnUserCurrentGeolocationBasedOnDatabase() throws IOException, GeoIp2Exception {

        //given
        GeolocationStub geolocationStub = new GeolocationStub();

        //when
        String userCityName = geolocationStub.getCityName();

        //then
        assertThat(userCityName, equalTo("Gorlice"));
    }
}