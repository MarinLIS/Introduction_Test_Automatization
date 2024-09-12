package ru.gb.lessons.lesson_02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrinciplesTest  extends AbstractTest{

    @Test
    void testOne () {
        //given
        System.out.println("testOne run");
        //when
        //then
        Assertions.assertTrue(() -> generalTestMethod(false));
    }

    @Test
    void testTwo () {
        //given
        System.out.println("testTwo run");
        //when
        //then
        Assertions.assertFalse( () -> generalTestMethod(true));
    }

    @Test
    void testThree () {
        //given
        System.out.println("testThree run");
        //when
        //then
        Assertions.assertThrows(NullPointerException.class, () -> generalTestMethod(null));
    }

    private boolean generalTestMethod (Boolean value) {
        return !value;
    }
}
