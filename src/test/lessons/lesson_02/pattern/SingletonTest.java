package ru.gb.lessons.lesson_02.pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.gb.lessons.lesson_02.pattern.singleton.*;

/**
 * Тест для демонстрации работы паттерна Одиночка
 */
public class SingletonTest {

    //Простая инициализация
    @Test
    void singletonSimpleTest () {
        //given
        SimpleSingleton singleton1 = SimpleSingleton.getInstance();
        SimpleSingleton singleton2 = SimpleSingleton.getInstance();
        //when
        singleton2.setUrl("https://newurl");
        //then
        Assertions.assertSame(singleton1, singleton2);
        Assertions.assertEquals("https://newurl", singleton1.getUrl());
    }

    //Ленивый метод инициализации
    @Test
    void singletonLazyTest () {
        //given
        LazySingleton singleton1 = LazySingleton.getInstance();
        LazySingleton singleton2 = LazySingleton.getInstance();
        //when
        singleton2.setUrl("https://newurl");
        //then
        Assertions.assertSame(singleton1, singleton2);
        Assertions.assertEquals("https://newurl", singleton1.getUrl());
    }

    //Метод инициализации статического блока
    @Test
    void staticBlockSingletonTest () {
        //given
        StaticBlockSingleton singleton1 = StaticBlockSingleton.getInstance();
        StaticBlockSingleton singleton2 = StaticBlockSingleton.getInstance();
        //when
        singleton2.setUrl("https://newurl");
        //then
        Assertions.assertSame(singleton1, singleton2);
        Assertions.assertEquals("https://newurl", singleton1.getUrl());
    }

    //Метод отложенной загрузки
    @Test
    void lazyLoadSingletonTest () {
        //given
        LazyLoadSingleton singleton1 = LazyLoadSingleton.getInstance();
        LazyLoadSingleton singleton2 = LazyLoadSingleton.getInstance();
        //when
        singleton2.setUrl("https://newurl");
        //then
        Assertions.assertSame(singleton1, singleton2);
        Assertions.assertEquals("https://newurl", singleton1.getUrl());
    }

    //Потокобезопасный метод
    @Test
    void threadSafeSingletonTest () {
        //given
        ThreadSafeSingleton singleton1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton singleton2 = ThreadSafeSingleton.getInstance();
        //when
        singleton2.setUrl("https://newurl");
        //then
        Assertions.assertSame(singleton1, singleton2);
        Assertions.assertEquals("https://newurl", singleton1.getUrl());
    }

    //Enum
    @Test
    void enumTest() {
        //given
        //when
        //then
        Assertions.assertEquals("http://", Connection.URL.getValue());
    }
}
