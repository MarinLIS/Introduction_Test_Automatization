package ru.gb.lessons.lesson_02.pattern.adapter;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Изначальный обработчик Json
 */
public class JsonObjectExample implements IJson{
    @Override
    public void openResponse() {
        System.out.println("open json");
    }

    @Override
    public Integer count() {
        return new Random(100).nextInt();
    }

    @Override
    public String findObject(String searchString) {
        return "";
    }

    @Override
    public String getAuthor() {
        return "fio";
    }

    @Override
    public Integer getSize() {
        return new Random(100).nextInt();
    }

    @Override
    public LocalDateTime getCreateDateTime() {
        return LocalDateTime.now();
    }
}
