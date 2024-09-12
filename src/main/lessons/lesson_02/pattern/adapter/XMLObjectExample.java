package ru.gb.lessons.lesson_02.pattern.adapter;

import java.time.LocalDate;
import java.util.Random;

/**
 * Изначальный обработчик XML
 */
public class XMLObjectExample implements IXml{
    @Override
    public void openXML() {
        System.out.println("open xml");
    }

    @Override
    public Integer countXMLRow() {
        return new Random(10).nextInt();
    }

    @Override
    public String findObjectInXML(String searchString) {
        return "";
    }

    @Override
    public Integer getSizeXML() {
        return new Random(10).nextInt();
    }

    @Override
    public LocalDate getCreateDate() {
        return LocalDate.now();
    }
}
