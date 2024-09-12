package ru.gb.lessons.lesson_01;

import org.junit.jupiter.api.*;

/*
    Демонстрация работы ЖЦ тестов
 */
public class ExampleLFDemoTest {

    @BeforeAll
    static void init() {
        System.out.println("init test run");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach test run");
    }

    @Test
    void exampleFirstTest() {
        //given
        //when
        System.out.println("exampleFirstTest test run");
        //then
    }

    @Test
    void exampleSecondTest() {
        //given
        //when
        System.out.println("exampleSecondTest test run");
        //then
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach test run");
    }

    @AfterAll
    static void exit() {
        System.out.println("exit test run");
    }
}
