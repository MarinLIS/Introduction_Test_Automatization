package ru.gb.homeworks.homework_03;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class OneDayOfDailyIndexValuesForASpecificIndexTest extends AccuweatherAbstractTest{

    @Test
    void getOneDayOfDailyIndexValuesForASpecificIndex() {

        List<Index> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/indices/v1/daily/1day/5/8")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .body().jsonPath().getList(".", Index.class);

        Assertions.assertEquals(1,response.size());
        Assertions.assertEquals("Outdoor Concert Forecast", response.get(0).getName());
    }
}
