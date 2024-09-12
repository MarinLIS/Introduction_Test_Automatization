package homeworks.homework_03;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CitySearchTest extends AccuweatherAbstractTest {

    @Test
    void getCitySearch() {

        List<Location> response = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Barnaul")
                .when()
                .get(getBaseUrl()+"/locations/v1/cities/search")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(2,response.size());
        Assertions.assertEquals("Barnaul", response.get(0).getEnglishName());
    }
}
