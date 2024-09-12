package ru.gb.seminars.seminar_03.accuweather;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.gb.seminars.seminar_03.accuweather.weather.Weather;

import static io.restassured.RestAssured.given;

public class GetWeatherFiveDayTest extends AccuweatherAbstractTest {

    @Test
    void getWeatherFiveDay_shouldReturn() {

        Weather response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/forecasts/v1/daily/5day/290396")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .response()
                .body().as(Weather.class);

        Assertions.assertEquals(5,response.getDailyForecasts().size());
    }
}
