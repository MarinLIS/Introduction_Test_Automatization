package ru.gb.seminars.seminar_01;

import ru.gb.seminars.seminar_01.type.Ranks;
import ru.gb.seminars.seminar_01.type.Suits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Сервис для работы с колодой карт
 */
public class DeckService {

    //Генерация новой колоды
    public Deck getNewDeck() {

        List<Card> cardList = new ArrayList<>();
        for(Ranks rank: Ranks.values()) {
            for (Suits suit: Suits.values()) {
                cardList.add(new Card(rank, suit));
            }
        }

        Deck result = new Deck(cardList);
        shuffle(result);
        return result;
    }

    //Перемешать колоду
    public void shuffle(Deck deck) {
        Collections.shuffle(deck.getCards());
    }
}
