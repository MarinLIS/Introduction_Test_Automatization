package ru.gb.homeworks.homework_03;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CurrentConditionsTest extends AccuweatherAbstractTest {

    @Test
    void getCurrentConditions() {

        List<CurrentCondition> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/currentconditions/v1/15")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .body().jsonPath().getList(".", CurrentCondition.class);

        Assertions.assertEquals(1,response.size());
        Assertions.assertEquals("http://www.accuweather.com/en/jp/oga-shi/16/current-weather/16?lang=en-us",
                response.get(0).getMobileLink());
    }

}
