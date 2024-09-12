package homeworks.homework_05;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FifteenDaysOfWeatherAlarmsTest extends AbstractTest{

    private static final Logger logger
            = LoggerFactory.getLogger(FifteenDaysOfWeatherAlarmsTest.class);


    @Test
    void getFifteenDaysOfWeatherAlarms_shouldReturn401() throws IOException, URISyntaxException {
        logger.info("Тест код ответ 401 запущен");
        //given
        logger.debug("Формируем мок GET /alarms/v1/15day/291662");
        stubFor(get(urlPathEqualTo("/alarms/v1/15day/291662"))
                .withQueryParam("apiKey", containing("MIt4YeAng1AxFCNwKAKYiYzBqhrinwkU"))
                .willReturn(aResponse()
                        .withStatus(401).withBody("Unauthorized")));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(getBaseUrl() + "/alarms/v1/15day/291662");
        URI uri = new URIBuilder(request.getURI())
                .addParameter("apiKey", "MIt4YeAng1AxFCNwKAKYiYzBqhrinwkU")
                .build();
        request.setURI(uri);
        logger.debug("http клиент создан");
        //when
        HttpResponse response = httpClient.execute(request);
        //then
        verify(getRequestedFor(urlPathEqualTo("/alarms/v1/15day/291662")));
        assertEquals(401, response.getStatusLine().getStatusCode());
        assertEquals("Unauthorized", convertResponseToString(response));
    }
}
