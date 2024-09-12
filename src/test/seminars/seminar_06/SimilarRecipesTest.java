package ru.gb.seminars.seminar_06;

import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic(value = "Тестирование API https://spoonacular.com/food-api")
@Feature(value = "Семинар")
public class SimilarRecipesTest extends AbstractTest {

    @Test
    @DisplayName("SimilarRecipesTest")
    @Description("GET SimilarRecipes")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Ткаченко Андрей")
    @Story(value = "Тестирование метода SimilarRecipes")
    void getSimilarRecipes_whenValid_shouldReturn() {
        List<SimilarRecipesDto> response = given()
                .queryParam("apiKey", getApiKey())
                .when()
                .get(getBaseUrl()+"recipes/715538/similar")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".", SimilarRecipesDto.class);

        Assertions.assertEquals(response.size(),10);
        response.forEach(v -> {
            if (v.getId().equals(209128)) {
                Assertions.assertEquals(v.getTitle(),"Dinner Tonight: Grilled Romesco-Style Pork");
            }
            if (v.getId().equals(31868)) {
                Assertions.assertEquals(v.getTitle(),"Dinner Tonight: Chickpea Bruschetta");
            }
        });
    }
}
