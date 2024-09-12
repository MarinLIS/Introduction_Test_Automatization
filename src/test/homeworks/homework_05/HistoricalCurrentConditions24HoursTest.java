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
import ru.gb.homeworks.homework_03.Historical;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoricalCurrentConditions24HoursTest extends AbstractTest{

    private static final Logger logger
            = LoggerFactory.getLogger(HistoricalCurrentConditions24HoursTest.class);

    @Test
    void getHistoricalCurrentConditions24Hours_shouldReturn200() throws IOException {
        logger.info("Тест код ответ 200 запущен");
        ObjectMapper mapper = new ObjectMapper();
        Historical historical = new Historical();
        historical.setLink("http://www.accuweather.com/en/gr/logos/2285860/current-weather/2285860?lang=en-us");

        logger.debug("Формируем мок GET /currentconditions/v1/5/historical/24");
        stubFor(get(urlPathEqualTo("/currentconditions/v1/5/historical/24"))
                .willReturn(aResponse().withStatus(200)
                        .withBody(mapper.writeValueAsString(historical))));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        logger.debug("http-клиент создан");

        HttpGet request = new HttpGet(getBaseUrl() + "/currentconditions/v1/5/historical/24");

        HttpResponse response = httpClient.execute(request);

        verify(getRequestedFor(urlPathEqualTo("/currentconditions/v1/5/historical/24")));
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertEquals("http://www.accuweather.com/en/gr/logos/2285860/current-weather/2285860?lang=en-us",
                mapper.readValue(response
                        .getEntity().getContent(), Historical.class).getLink());
    }


    @Test
    void getHistoricalCurrentConditions24Hours_shouldReturn401() throws IOException, URISyntaxException {
        logger.info("Тест код ответ 401 запущен");
        //given
        logger.debug("Формируем мок GET /currentconditions/v1/5/historical/24");
        stubFor(get(urlPathEqualTo("/currentconditions/v1/5/historical/24"))
                .withQueryParam("apiKey", containing("MIt4YeAng1AxFCNwKAKYiYzBqhrinwkU"))
                .willReturn(aResponse()
                        .withStatus(401).withBody("Unauthorized")));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(getBaseUrl()+"/currentconditions/v1/5/historical/24");
        URI uri = new URIBuilder(request.getURI())
                .addParameter("apiKey", "P_MIt4YeAng1AxFCNwKAKYiYzBqhrinwkU")
                .build();
        request.setURI(uri);
        logger.debug("http клиент создан");
        //when
        HttpResponse response = httpClient.execute(request);
        //then
        verify(getRequestedFor(urlPathEqualTo("/currentconditions/v1/5/historical/24")));
        assertEquals(401, response.getStatusLine().getStatusCode());
        assertEquals("Unauthorized", convertResponseToString(response));
    }
}
