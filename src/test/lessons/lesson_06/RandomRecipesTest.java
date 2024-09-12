package ru.gb.lessons.lesson_06;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

@Epic(value = "Тестирование API https://spoonacular.com/food-api")
@Feature(value = "Лекция 6")
public class RandomRecipesTest extends AbstractTest {

    private static final Logger logger
            = LoggerFactory.getLogger(RandomRecipesTest.class);

    @Test
    @DisplayName("RandomRecipesTest")
    @Description("GET RandomRecipes")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Ткаченко Андрей")
    @Story(value = "Тестирование метода RandomRecipes")
    void getRandomRecipes_whenValid_shouldReturn() {
        logger.info("Вызван метод получение рандомного рецепта");

        Response response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("number", 5)
                .when()
                .get(getBaseUrl() + "recipes/random")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(10000l))
                .extract()
                .response();

        SaveResultToDBService.insertEmployeeInfo(String.valueOf(response.statusCode()),
                "recipes/random",
                "GET",
                LocalDateTime.now().toString());

        Assertions.assertEquals(response.body().as(RandomRecipesDto.class).recipes.size(),5);
    }
}
