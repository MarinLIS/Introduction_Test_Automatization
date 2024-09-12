package ru.gb.lessons.lesson_01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
    Демонстрация работы с утверждениями
 */
public class AssertionsDemoTest {

    @Test
    @DisplayName("демонстрация утверждения assertTrue и assertFalse")
    void assertTrueAndAssertFalse() {
        //given
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
    @DisplayName("демонстрация утверждения assertArrayEquals")
    void assertArrayEquals() {
        //given
        String reference[] = new String[] {
                "Toyota", "Mercedes", "BMW", "Volkswagen", "Skoda" };
        //when
        String result[] = getArrayString();
        //then
        Assertions.assertArrayEquals(reference, result);
    }

    private String[] getArrayString() {
        String array[] = new String[] {
                "Toyota", "Mercedes", "BMW", "Volkswagen", "Skoda" };

        return array;
    }

    @Test
    @DisplayName("демонстрация утверждения assertNotNull и assertNull")
    void assertNotNullAndAssertNull() {
        //given
        Object isNullValue;
        Object isNotNullValue;
        //when
        isNullValue = getNull();
        isNotNullValue = getNotNull();
        //then
        Assertions.assertNotNull(isNotNullValue);
        Assertions.assertNull(isNullValue);
    }

    private Object getNull() {
        return null;
    }

    private Object getNotNull() {
        return new Object();
    }

    @Test
    @DisplayName("демонстрация утверждения assertThrows")
    void assertThrows() {
        //given
        //when
        Assertions.assertThrows(NullPointerException.class, () -> returnNullPointerException());
    }

    @Test
    @DisplayName("демонстрация утверждения assertAll")
    @Disabled
    void assertMultiple() {
        //given
        //when
        Assertions.assertAll(() -> Assertions.assertEquals("String", 100),
                () -> Assertions.assertThrows(NullPointerException.class, () -> returnNullPointerException()),
                () -> Assertions.assertTrue(false),
                () -> Assertions.assertFalse(true));
    }

    private Object returnNullPointerException() {
        throw new NullPointerException();
    }

    @Test
    @DisplayName("демонстрация не пройденного теста и assertEquals")
    @Disabled
    void failTest() {
        //given
        Object reference = new Object();
        //when
        Object result = getObject();
        //then
        Assertions.assertEquals(reference,result, "this object in not equals");
    }

    private Object getObject() {
        return new Object();
    }

    @Test
    @DisplayName("тест содержит ошибку и в принципе - всегда проверяйте, что ваши тесты работают")
    @Disabled
    void notWorkTest() {
        //given
        //when
        int a = 100/0;
        //then
        Assertions.assertTrue(true);
    }


}
