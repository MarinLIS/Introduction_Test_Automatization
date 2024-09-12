package ru.gb.homeworks.homework_03;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegionListTest extends AccuweatherAbstractTest{

    @Test
    void getRegionList() {

        List<Region> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/regions")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .body().jsonPath().getList(".", Region.class);

        Assertions.assertEquals(10,response.size());
        Assertions.assertEquals("Africa", response.get(0).getLocalizedName());
    }
}
