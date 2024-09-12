package ru.gb.lessons.lesson_02.pattern.adapter;

import java.time.LocalDateTime;

/**
 * Интерфейс обработчика Json
 */
public interface IJson {

    public void openResponse();

    public Integer count();

    public String findObject(String searchString);

    public String getAuthor();

    public Integer getSize();

    public LocalDateTime getCreateDateTime();
}
