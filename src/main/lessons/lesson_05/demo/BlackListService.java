package ru.gb.lessons.lesson_05.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BlackListService {

    private static final Logger logger
            = LoggerFactory.getLogger(BlackListService.class);

    public boolean isInBlackList(String clientId) {
        logger.info("Обращение к сервису черных списков для проверки клиента");
        return false;
    }

    public boolean isInWhiteList(String clientId) {
        logger.info("Обращение к сервису белых списков для проверки клиента");
        return true;
    }

    public boolean isInBlackListHttp(String clientId) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8888/test/black");
        //when
        HttpResponse httpResponse = httpClient.execute(request);

        return httpResponse.getStatusLine().getStatusCode() == 200;
    }
}
