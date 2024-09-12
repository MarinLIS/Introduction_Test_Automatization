package ru.gb.lessons.lesson_02.pattern.adapter;

import java.time.ZoneId;
import java.util.Date;

/**
 * Реализация Json адаптера
 */
public class JsonAdapter implements IAdapter{

    private JsonObjectExample json = new JsonObjectExample();

    @Override
    public void open() {
        json.openResponse();
    }

    @Override
    public Integer row() {
        return json.count();
    }

    @Override
    public String find(String searchString) {
        return json.findObject(searchString);
    }

    @Override
    public String author() {
        return json.getAuthor();
    }

    @Override
    public Integer size() {
        return json.getSize();
    }

    @Override
    public Date createDate() {
        return Date.from(json.getCreateDateTime().atZone(ZoneId.systemDefault()).toInstant());
    }
}
