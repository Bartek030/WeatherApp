package pl.bartlomiej_swies.model.auxiliaryMethods;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class DateMethodsTest {

    public static final long AUGUST_22_08 = 1629624690000L;

    @Test
    void getDayOfTheWeekFromNumberOfMillis() {

        //given
        //when
        String dayOfTheWeek = DateMethods.getDayOfTheWeekFromNumberOfMillis(AUGUST_22_08);

        //then
        assertThat(dayOfTheWeek, equalTo("niedziela"));
    }

    @Test
    void getDateFromNumberOfMillis() {

        //given
        //when
        String date = DateMethods.getDateFromNumberOfMillis(AUGUST_22_08);

        //then
        assertThat(date, equalTo("22-08-2021"));
    }
}