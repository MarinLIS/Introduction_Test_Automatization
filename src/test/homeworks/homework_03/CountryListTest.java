package homeworks.homework_03;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CountryListTest extends AccuweatherAbstractTest{

    @Test
    void getCountryList() {

        List<Country> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/countries/ARC")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .body().jsonPath().getList(".", Country.class);

        Assertions.assertEquals(2,response.size());
        Assertions.assertEquals("Greenland", response.get(0).getLocalizedName());
        Assertions.assertEquals("Iceland", response.get(1).getLocalizedName());
    }
}
