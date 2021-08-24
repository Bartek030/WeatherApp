package pl.bartlomiej_swies.model.auxiliaryMethods;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StringMethodsTest {

    @Test
    void shouldReturnStringWithCapitalizedFirstLetter() {

        //given
        String stringToTest = "przyklad do przetestowania";

        //when
        String capitalizedString = StringMethods.capitalizeFirstLetter(stringToTest);

        //then
        assertThat(capitalizedString, equalTo("Przyklad do przetestowania"));
    }

    @Test
    void shouldReturnNullWhenNullStringIsOnInput() {

        //given
        String stringToTest = null;

        //when
        String capitalizedString = StringMethods.capitalizeFirstLetter(stringToTest);

        //then
        assertThat(capitalizedString, nullValue());
    }

    @Test
    void shouldReturnEmptyStringWhenEmptyStringIsOnInput() {

        //given
        String stringToTest = "";

        //when
        String capitalizedString = StringMethods.capitalizeFirstLetter(stringToTest);

        //then
        assertThat(capitalizedString, equalTo(""));
    }
}