package ru.gb.lessons.lesson_01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Month;

/*
    Демонстрация работы параметризованного теста
 */
public class ParametrizedDemoTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10, -3, 15, Integer.MAX_VALUE})
    @DisplayName("демонстрация работы параметризованного теста с использование ValueSource")
    @Disabled
    void parameterizedTest(int number) {
        //given
        //when
        //then
        Assertions.assertTrue(isOdd(number));
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }

    @ParameterizedTest
    @DisplayName("демонстрация работы параметризованного теста с использование EnumSource")
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "DECEMBER"})
    @Disabled
    void someMonths_Are30DaysLong(Month month) {
        //given
        final boolean isALeapYear = false;
        //when
        //then
        Assertions.assertEquals(30, month.length(isALeapYear));
    }

    @ParameterizedTest
    @DisplayName("демонстрация работы параметризованного теста с использование CsvSource")
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
        //given
        String actualValue = input.toUpperCase();
        //when
        //then
        Assertions.assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @DisplayName("демонстрация работы параметризованного теста с использование CsvSource файла")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(
            String input, String expected) {
        //given
        //when
        String actualValue = input.toUpperCase();
        //then
        Assertions.assertEquals(expected, actualValue);
    }
}
