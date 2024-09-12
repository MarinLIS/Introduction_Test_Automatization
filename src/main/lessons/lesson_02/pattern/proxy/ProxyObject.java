package ru.gb.lessons.lesson_02.pattern.proxy;

import java.time.LocalDateTime;

/**
 * Прокси объект
 */
public class ProxyObject implements IClass{

    IClass iClass = new ClassExample();

    @Override
    public String sendGetRequest(Integer id) {
        logg("Направлено сообщение серверу", HttpMethod.GET);
        return iClass.sendGetRequest(id);
    }

    @Override
    public Boolean sendPostRequest(String request) {
        logg("Направлено сообщение серверу", HttpMethod.POST);
        return iClass.sendPostRequest(request);
    }

    @Override
    public Boolean sendPutRequest(String request, Integer id) {
        logg("Направлено сообщение серверу", HttpMethod.PUT);
        return iClass.sendPutRequest(request, id);
    }

    @Override
    public Boolean sendDeleteRequest(Integer id) {
        logg("Направлено сообщение серверу", HttpMethod.DELETE);
        return iClass.sendDeleteRequest(id);
    }

    private void logg(String str, HttpMethod method) {
        System.out.println(LocalDateTime.now() + " " + method.getValue() + " " + str);
    }
}
