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
import java.util.List;

import static io.restassured.RestAssured.given;

@Epic(value = "Тестирование API https://spoonacular.com/food-api")
@Feature(value = "Лекция 6")
public class SimilarRecipesTest extends AbstractTest {

    private static final Logger logger
            = LoggerFactory.getLogger(SimilarRecipesTest.class);

    @Test
    @DisplayName("SimilarRecipesTest")
    @Description("GET SimilarRecipes")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Ткаченко Андрей")
    @Story(value = "Тестирование метода SimilarRecipes")
    void getSimilarRecipes_whenValid_shouldReturn() {
        logger.info("Вызван метод получение рецепата");
        Response response = given()
                .queryParam("apiKey", getApiKey())
                .when()
                .get(getBaseUrl()+"recipes/715538/similar")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(20000l))
                .extract()
                .response();

        SaveResultToDBService.insertEmployeeInfo(String.valueOf(response.statusCode()),
                "recipes/715538/similar",
                "GET",
                LocalDateTime.now().toString());
        List<SimilarRecipesDto> similarRecipesDtos = response.body().jsonPath().getList(".", SimilarRecipesDto.class);

        Assertions.assertEquals(similarRecipesDtos.size(),10);
        similarRecipesDtos.forEach(v -> {
            if (v.getId().equals(209128)) {
                Assertions.assertEquals(v.getTitle(),"Dinner Tonight: Grilled Romesco-Style Pork");
            }
            if (v.getId().equals(31868)) {
                Assertions.assertEquals(v.getTitle(),"Dinner Tonight: Chickpea Bruschetta");
            }
        });
    }
}

