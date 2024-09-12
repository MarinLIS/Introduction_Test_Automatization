package ru.gb.seminars.seminar_01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Тест кейс для тестирования сервиса работы с колодой
 */
public class DeckServiceTest {

    @Test
    void getNewDeckTest () {
        //given
        DeckService deckService = new DeckService();
        //when
        Deck deck = deckService.getNewDeck();
        //then
        Assertions.assertEquals(52, deck.getCards().size());
    }

    @Test
    void shuffleTest () {
        //given
        DeckService deckService = new DeckService();
        //when
        Deck deck = deckService.getNewDeck();
        ArrayList<Card> cardsToCopy = new ArrayList<>();
        deck.getCards().forEach(card -> {
            cardsToCopy.add(card.copyCard());
        });
        deckService.shuffle(deck);
        //then
        Assertions.assertEquals(52, deck.getCards().size());
        Assertions.assertEquals(52, cardsToCopy.size());
        Assertions.assertFalse(checkToDeck(deck, cardsToCopy));
    }

    private boolean checkToDeck(Deck deck, ArrayList<Card> cardsToCopy) {
        for (int i = 0; i < 52; i++) {
            if(deck.getCards().get(i) != cardsToCopy.get(i)) return false;
        }

        return true;
    }
}
