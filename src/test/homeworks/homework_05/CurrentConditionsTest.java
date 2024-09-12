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
import ru.gb.homeworks.homework_03.CurrentCondition;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentConditionsTest extends AbstractTest{

    private static final Logger logger
            = LoggerFactory.getLogger(CurrentConditionsTest.class);

    @Test
    void getCurrentConditions_shouldReturn200() throws IOException {
        logger.info("Тест код ответ 200 запущен");
        ObjectMapper mapper = new ObjectMapper();
        CurrentCondition condition = new CurrentCondition();
        condition.setMobileLink("http://www.accuweather.com/en/jp/oga-shi/16/current-weather/16?lang=en-us");

        logger.debug("Формируем мок GET /currentconditions/v1/15");
        stubFor(get(urlPathEqualTo("/currentconditions/v1/15"))
                .willReturn(aResponse().withStatus(200)
                        .withBody(mapper.writeValueAsString(condition))));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        logger.debug("http-клиент создан");

        HttpGet request = new HttpGet(getBaseUrl() + "/currentconditions/v1/15");

        HttpResponse response = httpClient.execute(request);

        verify(getRequestedFor(urlPathEqualTo("/currentconditions/v1/15")));
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertEquals("http://www.accuweather.com/en/jp/oga-shi/16/current-weather/16?lang=en-us",
                mapper.readValue(response
                        .getEntity().getContent(), CurrentCondition.class).getMobileLink());
    }


    @Test
    void getCurrentConditions_shouldReturn401() throws IOException, URISyntaxException {
        logger.info("Тест код ответ 401 запущен");
        //given
        logger.debug("Формируем мок GET /currentconditions/v1/15");
        stubFor(get(urlPathEqualTo("/currentconditions/v1/15"))
                .withQueryParam("apiKey", containing("MIt4YeAng1AxFCNwKAKYiYzBqhrinwkU"))
                .willReturn(aResponse()
                        .withStatus(401).withBody("Unauthorized")));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(getBaseUrl()+"/currentconditions/v1/15");
        URI uri = new URIBuilder(request.getURI())
                .addParameter("apiKey", "Q_MIt4YeAng1AxFCNwKAKYiYzBqhrinwkU")
                .build();
        request.setURI(uri);
        logger.debug("http клиент создан");
        //when
        HttpResponse response = httpClient.execute(request);
        //then
        verify(getRequestedFor(urlPathEqualTo("/currentconditions/v1/15")));
        assertEquals(401, response.getStatusLine().getStatusCode());
        assertEquals("Unauthorized", convertResponseToString(response));
    }
}
