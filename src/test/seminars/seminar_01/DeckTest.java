package ru.gb.seminars.seminar_01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.seminars.seminar_01.exception.DeckEmptyException;

/**
 * Тест кейс для тестирования объекта колоды
 */
public class DeckTest {

    Deck deck;
    static DeckService deckService;

    @BeforeAll
    static void init () {
        deckService = new DeckService();
    }

    @BeforeEach
    void createNewDeck () {
        deck = new Deck(deckService.getNewDeck().getCards());
    }

    @Test
    void checkDeckSize () {
        //given
        //when
        //then
        Assertions.assertEquals(52,deck.getCards().size());
    }

    @Test
    void checkEmptyException() throws DeckEmptyException {
        //given
        //when
        for(int i = 0; i < 52; i++) {
            deck.getCard();
        }
        //then
        Assertions.assertThrows(DeckEmptyException.class, () -> deck.getCard());
    }
}
