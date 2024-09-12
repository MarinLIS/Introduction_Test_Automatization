package ru.gb.lessons.lesson_03.spoonacular;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LogDemoTestSpoonacular extends SpoonacularAbstractTest {

    @Test
    void logRequestTest() {
        given().log().parameters().log().method()
                .queryParam("apiKey", getApiKey())
                .queryParam("includeNutrition", "false")
                .pathParam("id", 716429)
                .when()
                .get(getBaseUrl()+"recipes/{id}/information")
                .then()
                .statusCode(200);
    }

    @Test
    void logResponseTest() {
        given()
                .when()
                .get(getBaseUrl()+"recipes/716429/information?" +
                        "includeNutrition=false&apiKey=" +getApiKey())
                .then().log().body()
                .statusCode(200);
    }

    @Test
    @Disabled
    void logFailTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("includeNutrition", "false")
                .pathParam("id", 716429)
                .when()
                .get(getBaseUrl()+"recipes/{id}/information")
                .then()
                .statusCode(400);
    }
}
