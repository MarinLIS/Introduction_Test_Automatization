package homeworks.homework_03;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class WeatherOneDayTest extends AccuweatherAbstractTest{

    @Test
    void getWeatherOneDay(){
        Weather weather = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/forecasts/v1/daily/1day/291662")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .body().as(Weather.class);

        Assertions.assertEquals(1, weather.getDailyForecasts().size());
    }
}
