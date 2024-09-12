package homeworks.homework_01;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTest {

    private static int testCounter = 0;

    @BeforeAll
    static void init() {
        System.out.println("Общий запуск всех тестов");
        testCounter = 0;
    }

    @BeforeEach
    void beforeEach() {
        testCounter++;
        System.out.println("Запуск теста #" + testCounter);
    }

    @AfterEach
    void afterEach() {
        System.out.println("Тест #" + testCounter + " завершен");
    }

    @AfterAll
    static void exit() {
        System.out.println("Все тесты завершены");
    }
}
