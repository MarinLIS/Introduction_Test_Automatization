package ru.gb.seminars.seminar_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Асбтрактный класс для описания игроков
 */
public abstract class Player {
    //рука игрока
    private List<Card> hand = new ArrayList<>();
    //сумма карт руки
    private int handSumm = 0;
    //имя игрока
    private String name;
    //максимальный риск на которой может пойти игрок
    private int risk;

    public Player(String name, int risk) {
        this.name = name;
        this.risk = risk;
    }

    //Новая игра (если колода та же)
    public void newGame (){
        hand.clear();
        handSumm = 0;
    }

    //Добавление карты на руку
    public void addCard(Card card) {
        hand.add(card);
        handSumm = handSumm + card.getRanksValue();
    }

    //Сумма на руке
    public int getHandSumm() {
        return handSumm;
    }

    //Печать руки
    public String printHand() {
        String result = "Имя игрока: " + " name;\n" +
                "Рука игрока: ";

        for(Card card: hand) {
            result = result + card.getCardValue() + "\n";
        }

        return result;
    }

    public String getName() {
        return name;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }
}
