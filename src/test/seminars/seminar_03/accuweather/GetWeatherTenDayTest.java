package ru.gb.seminars.seminar_03.accuweather;

import io.restassured.http.Method;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetWeatherTenDayTest extends AccuweatherAbstractTest{

    @Test
    void get_ten_day_return_401() {

        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", 290396)
                .when()
                .request(Method.GET,getBaseUrl()+"/forecasts/{version}/daily/10day/{location}")
                .then()
                .statusCode(401);
    }
}
