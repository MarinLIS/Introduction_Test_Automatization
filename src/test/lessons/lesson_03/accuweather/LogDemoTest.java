package ru.gb.lessons.lesson_03.accuweather;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LogDemoTest extends AccuweatherAbstractTest{

    @Test
    void logRequestTest() {
        given().log().parameters().log().method()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("top", 50)
                .when()
                .get(getBaseUrl()+"/locations/{version}/topcities/{top}")
                .then()
                .statusCode(200);
    }

    @Test
    void logResponseTest() {
        given().log().parameters()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("top", 50)
                .when()
                .get(getBaseUrl()+"/locations/{version}/topcities/{top}")
                .then().log().body()
                .statusCode(200);
    }

    @Test
    @Disabled
    void logFailTest() {
        given().log().parameters()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("top", 50)
                .when()
                .get(getBaseUrl()+"/locations/{version}/topcities/{top}")
                .then()
                .statusCode(200);
    }
}
