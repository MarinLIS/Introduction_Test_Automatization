package ru.gb.lessons.lesson_02.pattern.proxy;

/**
 * Интерфейс класса который мы планируем проксировать
 */
public interface IClass {

    String sendGetRequest(Integer id);

    Boolean sendPostRequest(String request);

    Boolean sendPutRequest(String request, Integer id);

    Boolean sendDeleteRequest(Integer id);


}
