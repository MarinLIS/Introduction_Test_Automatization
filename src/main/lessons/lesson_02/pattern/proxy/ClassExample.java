package ru.gb.lessons.lesson_02.pattern.proxy;

/**
 * Реализация прокси класса.
 * Предположим что это внешний класс, в который мы не можем вносить изменения.
 */
public class ClassExample implements IClass{
    @Override
    public String sendGetRequest(Integer id) {
        return "Response";
    }

    @Override
    public Boolean sendPostRequest(String request) {
        return true;
    }

    @Override
    public Boolean sendPutRequest(String request, Integer id) {
        return true;
    }

    @Override
    public Boolean sendDeleteRequest(Integer id) {
        return true;
    }
}
