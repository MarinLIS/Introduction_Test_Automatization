package ru.gb.lessons.lesson_01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
    Демонстрация работы с предположениями
 */
public class AssumptionsDemoTest {

    @Test
    @DisplayName("демонстрация предположения assumeTrue и assumeFalse")
    void assumeTrueAndAssumeFalse() {
        //given
        Assumptions.assumeFalse(false);
        Assumptions.assumeTrue(true);
        boolean falseValue;
        boolean trueValue;
        //when
        falseValue = getFalse();
        trueValue = getTrue();
        //then
        Assertions.assertTrue(trueValue);
        Assertions.assertFalse(falseValue);
    }

    private boolean getFalse() {
        return false;
    }

    private boolean getTrue() {
        return true;
    }

    @Test
    @DisplayName("демонстрация не выполненного предположения")
    void assumeFail() {
        //given
        Assumptions.assumeFalse(true);
        Assumptions.assumeTrue(false);
        boolean falseValue;
        boolean trueValue;
        //when
        falseValue = getFalse();
        trueValue = getTrue();
        //then
        Assertions.assertTrue(trueValue);
        Assertions.assertFalse(falseValue);
    }

    @Test
    @DisplayName("демонстрация предположения assumingThat")
    void assumingThat() {
        //given
        Assumptions.assumingThat("test".equals("test"), () -> {
            // perform these assertions only on the DEV server
            Assertions.assertEquals(8, Math.multiplyExact(4, 2));
        });

        Assumptions.assumingThat("Test".equals("test"), () -> {
            // perform these assertions only on the DEV server
            Assertions.assertEquals(10, Math.multiplyExact(4, 2));
        });
        //when
        //then
        Assertions.assertEquals(16, Math.multiplyExact(4, 4));
    }

}
