package ru.gb.lessons.lesson_02.pattern.adapter;

import java.time.ZoneId;
import java.util.Date;

/**
 * Реализация XML адаптера
 */
public class XMLAdapter implements IAdapter{

    XMLObjectExample xml = new XMLObjectExample();

    @Override
    public void open() {
        xml.openXML();
    }

    @Override
    public Integer row() {
        return xml.countXMLRow();
    }

    @Override
    public String find(String searchString) {
        return xml.findObjectInXML(searchString);
    }

    @Override
    public String author() {
        return "-";
    }

    @Override
    public Integer size() {
        return xml.getSizeXML();
    }

    @Override
    public Date createDate() {
        return Date.from(xml.getCreateDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
