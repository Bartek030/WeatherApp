package pl.bartlomiej_swies.model;

import org.junit.jupiter.api.Test;
import pl.bartlomiej_swies.model.geolocation.OpenWeatherMapApiClientStubForCurrentWeatherData;
import pl.bartlomiej_swies.model.geolocation.OpenWeatherMapApiClientStubForDailyForecastData;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

class OpenWeatherMapApiQueryTest {

    @Test
    void shouldReturnCorrectCityNameWhenJsonStringIsCorrect() throws IOException {

        //given
        OpenWeatherMapApiClient openWeatherMapApiClient = new OpenWeatherMapApiClientStubForCurrentWeatherData();
        OpenWeatherMapApiQuery openWeatherMapApiQuery = new OpenWeatherMapApiQuery(openWeatherMapApiClient);

        //when
        CurrentWeatherData currentWeatherData = openWeatherMapApiQuery.getCurrentWeatherData("sample string needed for this method");

        //then
        assertThat(currentWeatherData.getName(), equalTo("Gorlice"));
    }

    @Test
    void shouldReturnNullValueWhenCurrentWeatherDataFromApiNotFound() throws IOException {

        //given
        OpenWeatherMapApiClient openWeatherMapApiClient = mock(OpenWeatherMapApiClient.class);
        OpenWeatherMapApiQuery openWeatherMapApiQuery = new OpenWeatherMapApiQuery(openWeatherMapApiClient);

        //when
        CurrentWeatherData currentWeatherData = openWeatherMapApiQuery.getCurrentWeatherData("sample string needed for this method");

        //then
        assertThat(currentWeatherData, nullValue());
    }

    @Test
    void shouldReturnCorrectObjectWhenDailyForecastDataFromApiFound() throws IOException {

        //given
        OpenWeatherMapApiClient openWeatherMapApiClient = new OpenWeatherMapApiClientStubForDailyForecastData();
        OpenWeatherMapApiQuery openWeatherMapApiQuery = new OpenWeatherMapApiQuery(openWeatherMapApiClient);

        //when
        DailyForecastData dailyForecastData = openWeatherMapApiQuery.getDailyForecastData(21.54, 21.54);

        //then
        assertThat(dailyForecastData, notNullValue());
    }

    @Test
    void shouldReturnNullValueWhenDailyForecastDataFromApiNotFound() throws IOException {

        //given
        OpenWeatherMapApiClient openWeatherMapApiClient = mock(OpenWeatherMapApiClient.class);
        OpenWeatherMapApiQuery openWeatherMapApiQuery = new OpenWeatherMapApiQuery(openWeatherMapApiClient);

        //when
        DailyForecastData dailyForecastData = openWeatherMapApiQuery.getDailyForecastData(21.54, 21.54);

        //then
        assertThat(dailyForecastData, nullValue());
    }
}