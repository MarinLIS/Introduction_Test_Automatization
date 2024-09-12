package homeworks.homework_05;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.gb.seminars.seminar_03.accuweather.location.Country;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryListTest extends AbstractTest {

    private static final Logger logger
            = LoggerFactory.getLogger(CountryListTest.class);


    @Test
    void getCountryList_shouldReturn200() throws IOException {
        logger.info("Тест код ответ 200 запущен");
        ObjectMapper mapper = new ObjectMapper();
        Country country = new Country();
        country.setLocalizedName("Greenland");

        logger.debug("Формируем мок GET /locations/v1/countries/ARC");
        stubFor(get(urlPathEqualTo("/locations/v1/countries/ARC"))
                .willReturn(aResponse().withStatus(200)
                        .withBody(mapper.writeValueAsString(country))));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        logger.debug("http-клиент создан");

        HttpGet request = new HttpGet(getBaseUrl() + "/locations/v1/countries/ARC");

        HttpResponse response = httpClient.execute(request);

        verify(getRequestedFor(urlPathEqualTo("/locations/v1/countries/ARC")));
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertEquals("Greenland", mapper.readValue(response
                .getEntity().getContent(), Country.class).getLocalizedName());
    }


    @Test
    void getCountryList_shouldReturn401() throws IOException, URISyntaxException {
        logger.info("Тест код ответ 401 запущен");
        //given
        logger.debug("Формируем мок GET /locations/v1/countries/ARC");
        stubFor(get(urlPathEqualTo("/locations/v1/countries/ARC"))
                .withQueryParam("apiKey", containing("4mntXiAzkJI6JWapQAWQHhWVUD7VEI1E"))
                .willReturn(aResponse()
                        .withStatus(401).withBody("Unauthorized")));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(getBaseUrl()+"/locations/v1/countries/ARC");
        URI uri = new URIBuilder(request.getURI())
                .addParameter("apiKey", "P_4mntXiAzkJI6JWapQAWQHhWVUD7VEI1E")
                .build();
        request.setURI(uri);
        logger.debug("http клиент создан");
        //when
        HttpResponse response = httpClient.execute(request);
        //then
        verify(getRequestedFor(urlPathEqualTo("/locations/v1/countries/ARC")));
        assertEquals(401, response.getStatusLine().getStatusCode());
        assertEquals("Unauthorized", convertResponseToString(response));
    }
}
