package pl.bartlomiej_swies.model.geolocation;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.junit.jupiter.api.Test;
import pl.bartlomiej_swies.model.auxiliaryMethods.Connection;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GeolocationTest {

    private String gorliceIpAddress = "185.25.121.171";

    @Test
    void shouldReturnUserCurrentGeolocationBasedOnDatabase() throws IOException, GeoIp2Exception {

        //given
        Connection connection = mock(Connection.class);
        GeolocationProvider geolocationProvider = new Geolocation(connection);

        //when
        given(connection.getIpAddress()).willReturn(gorliceIpAddress);

        //then
        assertThat(geolocationProvider.getCityName(), equalTo("Gorlice"));
    }
}