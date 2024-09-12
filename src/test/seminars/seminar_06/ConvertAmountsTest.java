package ru.gb.seminars.seminar_06;

import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic(value = "Тестирование API https://spoonacular.com/food-api")
@Feature(value = "Семинар")
public class ConvertAmountsTest extends AbstractTest {

    @Test
    @DisplayName("ConvertAmountsTest")
    @Description("GET ConvertAmounts")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Ткаченко Андрей")
    @Story(value = "Тестирование метода ConvertAmounts")
    void getConvertAmounts_whenValid_shouldReturn() {
        ConvertAmountsDto response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("ingredientName", "flour")
                .queryParam("sourceAmount", 2.5)
                .queryParam("sourceUnit", "cups")
                .queryParam("targetUnit", "grams")
                .when()
                .get(getBaseUrl()+"recipes/convert")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(1000l))
                .extract()
                .response()
                .body().as(ConvertAmountsDto.class);

        Assertions.assertEquals(response.getTargetAmount(),312.5);

    }
}
