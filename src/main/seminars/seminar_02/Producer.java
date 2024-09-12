package ru.gb.seminars.seminar_02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс поставщика, реализующий интерфейс IProducer
 */
public class Producer implements IProducer{

    List<IConsumer> consumers = new ArrayList<>();

    @Override
    public boolean subscription(IConsumer consumer) {
        if (!consumers.contains(consumer)) consumers.add(consumer);
        else throw new  NotSubscriptionException();

        return true;
    }

    @Override
    public boolean cancel(IConsumer consumer) {
        if (consumers.contains(consumer)) consumers.remove(consumer);
        else throw new  NotSubscriptionException();

        return true;
    }

    public int getMessage (String message) {
        AtomicInteger countConsumer = new AtomicInteger();
        consumers.forEach(iConsumer -> {
            if(iConsumer.isLineFree()) {
                iConsumer.sendMessage(message);
                countConsumer.getAndIncrement();
            }
        });
        return countConsumer.get();
    }

}
