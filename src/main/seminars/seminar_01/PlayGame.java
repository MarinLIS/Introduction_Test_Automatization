package ru.gb.seminars.seminar_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Main класс для запуска BlackJack в цикле
 */
public class PlayGame {

    public static void main(String[] args) {


        HashMap<String, String> statistic = new LinkedHashMap<>();
        List<String> winnerName = new ArrayList<>();

        for (int i = 0; i<100; i++) {
            Gamer gamer = new Gamer(3);
            Casino casino = new Casino(0);
            Game game = new Game(gamer, casino);
            String winner = game.round();
            winnerName.add(winner);
            statistic.put("Game № " + i + 1, winner);
        }

        statistic.entrySet().forEach(System.out::println);
        System.out.println("Игрок выиграл: " + winnerName.stream().filter(v -> v.equals("Игрок")).count());

    }


}
