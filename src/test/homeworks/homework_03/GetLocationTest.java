package ru.gb.homeworks.homework_03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetLocationTest extends AccuweatherAbstractTest {

    @Test
    void getGetLocation() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Barnaul")
                .when()
                .get(getBaseUrl()+"/locations/v1/cities/autocomplete")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.get(0).getLocalizedName().contains("Barnaul"));
    }
}
