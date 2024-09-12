package ru.gb.lessons.lesson_02.pattern.builder;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Класс для демонстрации реализации паттерна Строитель
 */
public class TestObjectExampleBuilder {
    private String stringAttr = "test";
    private Integer integerAttr = 100;
    private Double doubleAttr = Double.valueOf(1000);
    private Short shortAttr = 10;
    private Boolean booleanAttr = true;
    private LocalDateTime localDateTimeAttr;
    private Random randomAttr;

    public TestObjectExampleBuilder setStringAttr(String stringAttr) {
        this.stringAttr = stringAttr;
        return this;
    }

    public TestObjectExampleBuilder setIntegerAttr(Integer integerAttr) {
        this.integerAttr = integerAttr;
        return this;
    }

    public TestObjectExampleBuilder setDoubleAttr(Double doubleAttr) {
        this.doubleAttr = doubleAttr;
        return this;
    }

    public TestObjectExampleBuilder setShortAttr(Short shortAttr) {
        this.shortAttr = shortAttr;
        return this;
    }

    public TestObjectExampleBuilder setBooleanAttr(Boolean booleanAttr) {
        this.booleanAttr = booleanAttr;
        return this;
    }

    public TestObjectExampleBuilder setLocalDateTimeAttr(LocalDateTime localDateTimeAttr) {
        this.localDateTimeAttr = localDateTimeAttr;
        return this;
    }

    public TestObjectExampleBuilder setRandomAttr(Random randomAttr) {
        this.randomAttr = randomAttr;
        return this;
    }

    public TestObjectExample build() {
        return new TestObjectExample(stringAttr, integerAttr, doubleAttr, shortAttr, booleanAttr, localDateTimeAttr, randomAttr);
    }
}