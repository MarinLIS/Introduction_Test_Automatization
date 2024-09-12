package ru.gb.homeworks.homework_03;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ListOfIndexGroupsTest extends AccuweatherAbstractTest{

    @Test
    void getListOfIndexGroups() {

        List<MetaData> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/indices/v1/daily/groups")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .body().jsonPath().getList(".", MetaData.class);

        Assertions.assertEquals(47,response.size());
        Assertions.assertEquals("All API", response.get(0).getName());
    }
}

