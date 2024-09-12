package ru.gb.homeworks.homework_03;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ListOfIndicesInASpecificGroupTest extends AccuweatherAbstractTest{

    @Test
    void getListOfIndicesInASpecificGroup() {

        List<MetaData> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/indices/v1/daily/groups/8")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .body().jsonPath().getList(".", MetaData.class);

        Assertions.assertEquals(3,response.size());
        Assertions.assertEquals("Fishing Forecast", response.get(0).getName());
    }
}
