package ru.gb.homeworks.homework_03;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class HistoricalCurrentConditions24HoursTest extends AccuweatherAbstractTest {

    @Test
    void getHistoricalCurrentConditions24Hours() {

        List<Historical> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/currentconditions/v1/5/historical/24")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .body().jsonPath().getList(".", Historical.class);

        Assertions.assertEquals(24,response.size());
        Assertions.assertEquals("http://www.accuweather.com/en/gr/logos/2285860/current-weather/2285860?lang=en-us", response.get(0).getLink());
    }
}
