package ru.gb.lessons.lesson_05.demo;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.mockito.ArgumentMatchers.anyString;

public class BankCreditTest {

    static WireMockServer wireMockServer = new WireMockServer(8888);

    @ParameterizedTest
    @CsvSource({"100, 10, 100000, 500", "101, 20, 10000, 5000", "102, 5, 5000, 1000"})
    void when_valid_should_return(String clientId, String period, String summ, String initSum) throws BankCreditException {
        BlackListService blackListService = Mockito.mock(BlackListService.class);
        CreditParamRepository creditParamRepository = Mockito.mock(CreditParamRepository.class);
        BankCreditService bankCreditService = new BankCreditService(blackListService, creditParamRepository);

        Mockito.when(blackListService.isInBlackList(anyString())).thenReturn(false);

        Mockito.when(creditParamRepository.getCreditParams(anyString(),anyString(),anyString())).thenReturn(Optional.of(new CreditParam()));

        CreditParam creditParam = bankCreditService.getParams(clientId, period, summ, initSum);
        Assertions.assertNotNull(creditParam);
        Mockito.verify(blackListService,Mockito.times(1)).isInBlackList(anyString());
        Mockito.verify(creditParamRepository,Mockito.times(1)).getCreditParams(anyString(),anyString(),anyString());

    }

    @ParameterizedTest
    @CsvSource({"100, aaa, 100000, 500", "101, 20, aaaa, 5000", "102, 5, 5000, aaaa"})
    void when_notvalid_should_throw(String clientId, String period, String summ, String initSum) throws BankCreditException {
        BlackListService blackListService = Mockito.mock(BlackListService.class);
        CreditParamRepository creditParamRepository = Mockito.mock(CreditParamRepository.class);
        BankCreditService bankCreditService = new BankCreditService(blackListService, creditParamRepository);

        Mockito.when(blackListService.isInBlackList(anyString())).thenReturn(false);

        Mockito.when(creditParamRepository.getCreditParams(anyString(),anyString(),anyString())).thenReturn(Optional.of(new CreditParam()));

        Assertions.assertThrows(BankCreditException.class,
                () -> bankCreditService.getParams(clientId, period, summ, initSum));

        Mockito.verify(blackListService,Mockito.times(1)).isInBlackList(anyString());
        Mockito.verify(creditParamRepository,Mockito.never()).getCreditParams(anyString(),anyString(),anyString());

    }

    @Test
    void when_in_black_list_should_throw() {
        BlackListService blackListService = Mockito.mock(BlackListService.class);
        BankCreditService bankCreditService = new BankCreditService(blackListService, new CreditParamRepository());
        Mockito.when(blackListService.isInBlackList(anyString())).thenReturn(true);
        Assertions.assertThrows(BankCreditException.class,
                () -> bankCreditService.getParams("100","10","100000","500"));
        Mockito.verify(blackListService,Mockito.times(1)).isInBlackList(anyString());
        Mockito.verify(blackListService,Mockito.never()).isInWhiteList(anyString());
    }

    @Test
    void when_in_black_list_http_should_throw() {
        configureFor("localhost", 8888);
        wireMockServer.start();

        stubFor(get(urlPathMatching("/test/.*"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("\"black\": \"true\"")));

        BankCreditService bankCreditService = new BankCreditService(new BlackListService(), new CreditParamRepository());

        Assertions.assertThrows(BankCreditException.class,
                () -> bankCreditService.getHttpParams("100","10","100000","500"));

        wireMockServer.stop();
    }

    @Test
    void when_not_param_should_throw() {
        BlackListService blackListService = Mockito.mock(BlackListService.class);
        CreditParamRepository creditParamRepository = Mockito.mock(CreditParamRepository.class);
        BankCreditService bankCreditService = new BankCreditService(blackListService, creditParamRepository);
        Mockito.when(blackListService.isInBlackList(anyString())).thenReturn(false);

        Mockito.when(creditParamRepository.getCreditParams(anyString(),anyString(),anyString())).thenReturn(Optional.empty());

        Assertions.assertThrows(BankCreditException.class,
                () -> bankCreditService.getParams("100","10","100000","500"));
        Mockito.verify(blackListService,Mockito.times(1)).isInBlackList(anyString());
        Mockito.verify(creditParamRepository,Mockito.times(1)).getCreditParams(anyString(),anyString(),anyString());

    }
}
