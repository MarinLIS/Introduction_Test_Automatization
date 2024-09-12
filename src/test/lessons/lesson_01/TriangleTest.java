package ru.gb.lessons.lesson_01;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest extends AbstractTest {

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5, 6.0",
            "7, 10, 5, 16.24807680927192",
            "5, 5, 5, 10.825317547305486",
            "1, 1, 1, 0.4330127018922193"
    })
    void testSquareWithValidTriangles(int a, int b, int c, double expectedSquare) {
        Triangle triangle = new Triangle(a, b, c);
        assertEquals(expectedSquare, triangle.square(), 0.001, "Площадь треугольника не соответствует ожидаемой");
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "1, 2, 4",
            "2, 3, 100",
            "-3, 4, 5",
            "0, 3, 4"
    })
    void testInvalidTriangles(int a, int b, int c) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(a, b, c);
        });
        assertEquals("Стороны не могут образовать треугольник", exception.getMessage());
    }
}
