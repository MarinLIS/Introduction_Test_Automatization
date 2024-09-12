package ru.gb.lessons.lesson_01;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(7, 10, 5);
        System.out.println("Площадь треугольника равна: " + triangle.square());
    }
}
