package pl.bartlomiej_swies.model.auxiliaryMethods;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class DateMethodsTest {

    @Test
    void getDayOfTheWeekFromNumberOfMillis() {

        //given
        long numberOfMillis = 1629624690000l;

        //when
        String dayOfTheWeek = DateMethods.getDayOfTheWeekFromNumberOfMillis(numberOfMillis);

        //then
        assertThat(dayOfTheWeek, equalTo("niedziela"));
    }

    @Test
    void getDateFromNumberOfMillis() {

        //given
        long numberOfMillis = 1629624690000l;

        //when
        String date = DateMethods.getDateFromNumberOfMillis(numberOfMillis);

        //then
        assertThat(date, equalTo("22-08-2021"));
    }
}