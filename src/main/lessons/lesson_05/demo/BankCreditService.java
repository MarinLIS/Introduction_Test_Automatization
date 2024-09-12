package ru.gb.lessons.lesson_05.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

public class BankCreditService {
    private final BlackListService blackListService;
    private final CreditParamRepository creditParamRepository;

    private static final Logger logger
            = LoggerFactory.getLogger(BankCreditService.class);

    public BankCreditService(BlackListService blackListService, CreditParamRepository creditParamRepository) {
        this.blackListService = blackListService;
        this.creditParamRepository = creditParamRepository;
    }

    public CreditParam getParams(String clientId, String period, String summ, String initSumm) throws BankCreditException {
        logger.info("Вызван сервис получения данных для расчета кредита");
        if(blackListService.isInBlackList(clientId)) {
            logger.info("Клиент в черном списке: " + clientId);
            throw new BankCreditException("Клиент в черном списке");
        }

        try {
            Integer testperiod = Integer.valueOf(period);
            Integer testsumm = Integer.valueOf(summ);
            Integer testinitSumm = Integer.valueOf(initSumm);
        } catch (IllegalArgumentException ex) {
            logger.info("Данные для расчета кредита не валидны");
            throw new BankCreditException("Не валидные данные");
        }

        Optional<CreditParam> creditParam = creditParamRepository.getCreditParams(period, summ, initSumm);
        if(creditParam.isPresent()) {
            logger.info("Данные для расчета кредита получены");
            return creditParam.get();
        } else {
            logger.info("Данные для расчета кредита не найдены");
            throw new BankCreditException("Данные по запросу не найдены");
        }

    }

    public CreditParam getHttpParams(String clientId, String period, String summ, String initSumm) throws BankCreditException, IOException {
        logger.info("Вызван сервис получения данных для расчета кредита");
        if(blackListService.isInBlackListHttp(clientId)) {
            logger.info("Клиент в черном списке: " + clientId);
            throw new BankCreditException("Клиент в черном списке");
        }

        try {
            Integer testperiod = Integer.valueOf(period);
            Integer testsumm = Integer.valueOf(summ);
            Integer testinitSumm = Integer.valueOf(initSumm);
        } catch (IllegalArgumentException ex) {
            logger.info("Данные для расчета кредита не валидны");
            throw new BankCreditException("Не валидные данные");
        }

        Optional<CreditParam> creditParam = creditParamRepository.getCreditParams(period, summ, initSumm);
        if(creditParam.isPresent()) {
            logger.info("Данные для расчета кредита получены");
            return creditParam.get();
        } else {
            logger.info("Данные для расчета кредита не найдены");
            throw new BankCreditException("Данные по запросу не найдены");
        }

    }
}
