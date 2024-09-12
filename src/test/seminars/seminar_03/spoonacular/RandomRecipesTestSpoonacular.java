package ru.gb.seminars.seminar_03.spoonacular;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RandomRecipesTestSpoonacular extends SpoonacularAbstractTest {

    @Test
    void getRandomRecipes_whenValid_shouldReturn() {
        RandomRecipesDto response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("number", 5)
                .when()
                .get(getBaseUrl() + "recipes/random")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(1000l))
                .extract()
                .response()
                .body().as(RandomRecipesDto.class);

        Assertions.assertEquals(response.recipes.size(),5);
    }
}
