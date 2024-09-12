package ru.gb.homeworks.homework_05;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.gb.homeworks.homework_03.Index;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneDayOfDailyIndexValuesForASpecificIndexTest extends AbstractTest{

    private static final Logger logger
            = LoggerFactory.getLogger(OneDayOfDailyIndexValuesForASpecificIndexTest.class);

    @Test
    void getOneDayOfDailyIndexValuesForASpecificIndex_shouldReturn200() throws IOException {
        logger.info("Тест код ответ 200 запущен");
        ObjectMapper mapper = new ObjectMapper();
        Index index = new Index();
        index.setName("Outdoor Concert Forecast");

        logger.debug("Формируем мок GET /indices/v1/daily/1day/5/8");
        stubFor(get(urlPathEqualTo("/indices/v1/daily/1day/5/8"))
                .willReturn(aResponse().withStatus(200)
                        .withBody(mapper.writeValueAsString(index))));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        logger.debug("http-клиент создан");

        HttpGet request = new HttpGet(getBaseUrl() + "/indices/v1/daily/1day/5/8");

        HttpResponse response = httpClient.execute(request);

        verify(getRequestedFor(urlPathEqualTo("/indices/v1/daily/1day/5/8")));
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertEquals("Outdoor Concert Forecast",
                mapper.readValue(response.getEntity().getContent(), Index.class).getName());
    }


    @Test
    void getOneDayOfDailyIndexValuesForASpecificIndex_shouldReturn401() throws IOException, URISyntaxException {
        logger.info("Тест код ответ 401 запущен");
        //given
        logger.debug("Формируем мок GET /indices/v1/daily/1day/5/8");
        stubFor(get(urlPathEqualTo("/indices/v1/daily/1day/5/8"))
                .withQueryParam("apiKey", containing("MIt4YeAng1AxFCNwKAKYiYzBqhrinwkU"))
                .willReturn(aResponse()
                        .withStatus(401).withBody("Unauthorized")));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(getBaseUrl()+"/indices/v1/daily/1day/5/8");
        URI uri = new URIBuilder(request.getURI())
                .addParameter("apiKey", "B_MIt4YeAng1AxFCNwKAKYiYzBqhrinwkU")
                .build();
        request.setURI(uri);
        logger.debug("http клиент создан");
        //when
        HttpResponse response = httpClient.execute(request);
        //then
        verify(getRequestedFor(urlPathEqualTo("/indices/v1/daily/1day/5/8")));
        assertEquals(401, response.getStatusLine().getStatusCode());
        assertEquals("Unauthorized", convertResponseToString(response));
    }
}
