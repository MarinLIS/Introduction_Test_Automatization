package ru.gb.homeworks.homework_02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTest {

    protected static int testCount = 0;

    @BeforeEach
    public void setUp() {
        testCount++;
        System.out.println("Запуск теста #" + testCount);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Тест #" + testCount + " завершен");
    }
}
