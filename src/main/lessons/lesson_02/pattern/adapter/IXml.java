package ru.gb.lessons.lesson_02.pattern.adapter;

import java.time.LocalDate;

/**
 * Интерфейс обработчика XML
 */
public interface IXml {

    public void openXML();

    public Integer countXMLRow();

    public String findObjectInXML(String searchString);

    public Integer getSizeXML();

    public LocalDate getCreateDate();
}
