package ru.gb.lessons.lesson_02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTest {

    @BeforeAll
    static void init() {
        System.out.println("init test run");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach test run");
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
