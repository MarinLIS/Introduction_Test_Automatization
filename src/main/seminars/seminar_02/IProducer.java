package ru.gb.seminars.seminar_02;

/**
 * Интерфейс поставщика
 */
public interface IProducer {

    public boolean subscription(IConsumer consumer);

    public boolean cancel(IConsumer consumer);
}
