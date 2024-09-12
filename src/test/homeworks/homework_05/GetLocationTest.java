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
import ru.gb.homeworks.homework_03.Location;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetLocationTest extends AbstractTest{

    private static final Logger logger
            = LoggerFactory.getLogger(GetLocationTest.class);


    @Test
    void getGetLocation_shouldReturn200() throws IOException {
        logger.info("Тест код ответ 200 запущен");
        ObjectMapper mapper = new ObjectMapper();
        Location city = new Location();
        city.setLocalizedName("Barnaul");

        logger.debug("Формируем мок GET /locations/v1/cities/autocomplete");
        stubFor(get(urlPathEqualTo("/locations/v1/cities/autocomplete"))
                .willReturn(aResponse().withStatus(200)
                        .withBody(mapper.writeValueAsString(city))));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        logger.debug("http-клиент создан");

        HttpGet request = new HttpGet(getBaseUrl() + "/locations/v1/cities/autocomplete");

        HttpResponse response = httpClient.execute(request);

        verify(getRequestedFor(urlPathEqualTo("/locations/v1/cities/autocomplete")));
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertEquals("Barnaul", mapper.readValue(response
                .getEntity().getContent(), Location.class).getLocalizedName());
    }


    @Test
    void getGetLocation_shouldReturn401() throws IOException, URISyntaxException {
        logger.info("Тест код ответ 401 запущен");
        //given
        logger.debug("Формируем мок GET /locations/v1/cities/autocomplete");
        stubFor(get(urlPathEqualTo("/locations/v1/cities/autocomplete"))
                .withQueryParam("apiKey", containing("MIt4YeAng1AxFCNwKAKYiYzBqhrinwkU"))
                .willReturn(aResponse()
                        .withStatus(401).withBody("Unauthorized")));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(getBaseUrl()+"/locations/v1/cities/autocomplete");
        URI uri = new URIBuilder(request.getURI())
                .addParameter("apiKey", "Q_MIt4YeAng1AxFCNwKAKYiYzBqhrinwkU")
                .build();
        request.setURI(uri);
        logger.debug("http клиент создан");
        //when
        HttpResponse response = httpClient.execute(request);
        //then
        verify(getRequestedFor(urlPathEqualTo("/locations/v1/cities/autocomplete")));
        assertEquals(401, response.getStatusLine().getStatusCode());
        assertEquals("Unauthorized", convertResponseToString(response));
    }
}
