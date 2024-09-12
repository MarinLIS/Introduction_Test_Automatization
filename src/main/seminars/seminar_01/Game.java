package ru.gb.seminars.seminar_01;

import ru.gb.seminars.seminar_01.exception.DeckEmptyException;

public class Game {

    private Deck deck;

    public Game(Gamer gamer, Casino casino) {
        this.gamer = gamer;
        this.casino = casino;
        newDeck();
    }

    private Gamer gamer;
    private Casino casino;
    private final int max = 21;

    //Новая колода
    public void newDeck() {
        DeckService deckService = new DeckService();
        deck = deckService.getNewDeck();
    }

    public Game() {
        this.gamer = new Gamer(3);
        this.casino = new Casino(3);
        newDeck();
    }


    //Добавление карты в руку игрока
    public void addCardToPlayer() {
        try {
            gamer.addCard(deck.getCard());
        } catch (DeckEmptyException e) {
            e.printStackTrace();
        }
    }

    //Добавление карты в руку казино
    public void addCardToCasino() {
        try {
            casino.addCard(deck.getCard());
        } catch (DeckEmptyException e) {
            e.printStackTrace();
        }
    }

    //Проверка, что сумма на руке не выше лимита
    private boolean checkHand(Player player) {
        return player.getHandSumm() <= max ;
    }

    private boolean checkHand21(Player player) {
        return player.getHandSumm() == max ;
    }

    //Проверка, что сумма на руке не риска и можно взять еще карту
    private boolean checkRisk(Player player) {
        return player.getHandSumm() > max - player.getRisk() ;
    }


    /**
     * Этап в рамках одной игры
     * Игроку и казино раздаются карты, проверяется, что не превысили лимит
     * Если лимит не превышен проверяются риски
     * Иначе рекурсивно функция вызывает саму себя
     * @return
     */
    public String round () {

        this.addCardToPlayer();
        this.addCardToCasino();

        Player winner = getWinner(this.getGamer(), this.getCasino());
        if(winner != null) return winner.getName();

        return round();
    }

    public Player getWinner (Player gamer, Player casino) {
        if (this.checkHand21(gamer)) {
            return gamer;
        }

        if (this.checkHand21(casino)) {
            return casino;
        }

        if (!this.checkHand(gamer)) {
            return casino;
        }

        if (!this.checkHand(casino)) {
            return gamer;
        }

        if (checkRisk(gamer)) {
            if(gamer.getHandSumm() > casino.getHandSumm() && !checkRisk(this.getCasino())) {
                this.addCardToCasino();
            }
            return gamer.getHandSumm() > casino.getHandSumm()? gamer : casino;
        }
        return null;
    }

    public void printHand(Player player) {
        System.out.println(player.printHand());
    }

    public Gamer getGamer() {
        return gamer;
    }

    public Casino getCasino() {
        return casino;
    }

    public Deck getDeck() {
        return deck;
    }

}
