package ru.gb.homeworks.homework_03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SearchByLocationKeyTest extends AccuweatherAbstractTest {

    @Test
    void getSearchByLocationKey() {

        Location location = given()
                .queryParam("apikey", getApiKey())
                .pathParam("location", 291662)
                .when()
                .get(getBaseUrl() + "/locations/v1/{location}")
                .then()
                .statusCode(200)
                .extract()
                .body().as(Location.class);

        Assertions.assertEquals("291662", location.getKey());
        Assertions.assertEquals("Barnaul", location.getLocalizedName());
        Assertions.assertEquals("Russia", location.getCountry().getLocalizedName());
        Assertions.assertEquals("Altay", location.getAdministrativeArea().getLocalizedName());
    }
}
