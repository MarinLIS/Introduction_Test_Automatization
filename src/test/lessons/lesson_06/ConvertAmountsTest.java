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
public class ConvertAmountsTest extends AbstractTest {

    private static final Logger logger
            = LoggerFactory.getLogger(ConvertAmountsTest.class);

    @Test
    @DisplayName("ConvertAmountsTest")
    @Description("GET ConvertAmounts")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Ткаченко Андрей")
    @Story(value = "Тестирование метода ConvertAmounts")
    void getConvertAmounts_whenValid_shouldReturn() {
        logger.info("Вызван метод конвертации");
        Response response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("ingredientName", "flour")
                .queryParam("sourceAmount", 2.5)
                .queryParam("sourceUnit", "cups")
                .queryParam("targetUnit", "grams")
                .when()
                .get(getBaseUrl()+"recipes/convert")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(10000l))
                .extract()
                .response();

        SaveResultToDBService.insertEmployeeInfo(String.valueOf(response.statusCode()),
                "recipes/convert",
                "GET",
                LocalDateTime.now().toString());

        Assertions.assertEquals(response.body().as(ConvertAmountsDto.class).getTargetAmount(),312.5);

    }
}
