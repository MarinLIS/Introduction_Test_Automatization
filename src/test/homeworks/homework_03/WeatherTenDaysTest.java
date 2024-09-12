package homeworks.homework_03;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class WeatherTenDaysTest extends AccuweatherAbstractTest {


    @Test
    void getWeatherTenDays_shouldReturn401() {
        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", 291662)
                .when()
                .get(getBaseUrl() + "/forecasts/{version}/daily/10day/{location}")
                .then()
                .statusCode(401);
    }
}
