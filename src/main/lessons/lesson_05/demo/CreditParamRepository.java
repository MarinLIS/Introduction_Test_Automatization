package ru.gb.lessons.lesson_05.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class CreditParamRepository {

    private static final Logger logger
            = LoggerFactory.getLogger(CreditParamRepository.class);

    public Optional<CreditParam> getCreditParams(String period, String summ, String initSumm) {
        logger.info("Обращение к базе данных за параметрами кредита");
        return null;
    }
}
