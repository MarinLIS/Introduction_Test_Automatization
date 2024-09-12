package ru.gb.seminars.seminar_02;

/**
 * Интерфейс потребителя
 */
public interface IConsumer {

    //Передача сообщения
    public Status sendMessage(String str);

    //Проверка доступности линии
    public boolean isLineFree();
}
