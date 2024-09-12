package ru.gb.homeworks.homework_03;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class AdminAreaListTest extends AccuweatherAbstractTest {

    @Test
    void getAdminAreaList() {

        List<AdministrativeArea> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/adminareas/MEA")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .body().jsonPath().getList(".", AdministrativeArea.class);

        Assertions.assertEquals(21,response.size());
        Assertions.assertEquals("Andrijevica", response.get(0).getLocalizedName());
    }
}
