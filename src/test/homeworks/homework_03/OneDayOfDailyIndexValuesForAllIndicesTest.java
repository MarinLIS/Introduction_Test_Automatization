package ru.gb.homeworks.homework_03;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class OneDayOfDailyIndexValuesForAllIndicesTest extends AccuweatherAbstractTest {

    @Test
    void getOneDayOfDailyIndexValuesForAllIndices() {

        List<Index> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/indices/v1/daily/1day/5")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .body().jsonPath().getList(".", Index.class);

        Assertions.assertEquals(48,response.size());
        Assertions.assertEquals("Flight Delays", response.get(0).getName());
    }
}
