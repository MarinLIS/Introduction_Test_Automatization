package ru.gb.lessons.lesson_01;

public class Triangle {
    private final int a;
    private final int b;
    private final int c;

    public Triangle(int a, int b, int c) {

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Стороны не могут образовать треугольник");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double square() {

        double p = (a + b + c) / 2.0;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
