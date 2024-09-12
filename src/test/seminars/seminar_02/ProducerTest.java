package ru.gb.seminars.seminar_02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Тест для демонстрации работы паттерна Наблюдатель
 */
public class ProducerTest {

    @Test
    void producerTest () {
        //given
        ConsumerTelegram consumerTelegram = new ConsumerTelegram();
        ConsumerViber consumerViber = new ConsumerViber();
        Producer producer = new Producer();
        producer.subscription(consumerTelegram);
        producer.subscription(consumerViber);
        //when
        int count = producer.getMessage("Сообщение");
        //then
        Assertions.assertEquals(2, count);

    }

    @Test
    void producerNullConsumerTest () {
        //given
        Producer producer = new Producer();
        //when
        int count = producer.getMessage("Сообщение");
        //then
        Assertions.assertEquals(0, count);

    }

    @Test
    void producerBusyConsumerTest () {
        //given
        ConsumerTelegram consumerTelegram = new ConsumerTelegram();
        ConsumerViber consumerViber = new ConsumerViber();
        Producer producer = new Producer();
        //when
        producer.subscription(consumerTelegram);
        producer.subscription(consumerViber);
        int count = producer.getMessage("Сообщение");
        consumerTelegram.setFree(false);
        count = count + producer.getMessage("Сообщение");
        //then
        Assertions.assertFalse(consumerTelegram.isLineFree());
        Assertions.assertFalse(consumerViber.isLineFree());
        Assertions.assertEquals(2, count);

    }
}
