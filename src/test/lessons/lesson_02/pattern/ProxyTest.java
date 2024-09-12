package ru.gb.lessons.lesson_02.pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lessons.lesson_02.pattern.proxy.ClassExample;
import ru.gb.lessons.lesson_02.pattern.proxy.IClass;
import ru.gb.lessons.lesson_02.pattern.proxy.ProxyObject;

/**
 * Тест для демонстрации работы паттерна Прокси
 */
public class ProxyTest {

    @Test
    @DisplayName("Взаимодействие с ClassExample классом на прямую")
    void simpleTest () {
        //given
        IClass classExample = new ClassExample();
        //when
        //then
        Assertions.assertTrue(classExample.sendPostRequest(""));
        Assertions.assertTrue(classExample.sendPutRequest("",10));
        Assertions.assertTrue(classExample.sendDeleteRequest(10));
        Assertions.assertEquals("Response", classExample.sendGetRequest(10));
    }

    @Test
    @DisplayName("Взаимодействие с ClassExample классом через созданный класс ProxyObject")
    void proxyTest () {
        //given
        IClass proxyObject = new ProxyObject();
        //when
        //then
        Assertions.assertTrue(proxyObject.sendPostRequest(""));
        Assertions.assertTrue(proxyObject.sendPutRequest("",10));
        Assertions.assertTrue(proxyObject.sendDeleteRequest(10));
        Assertions.assertEquals("Response", proxyObject.sendGetRequest(10));
    }
}
