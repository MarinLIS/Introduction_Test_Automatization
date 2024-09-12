package homeworks.homework_01;

public class MontyHallParadox {
    private final int numberOfGames;
    private final boolean switchDoor;

    public MontyHallParadox(int numberOfGames, boolean switchDoor) {

        if (numberOfGames <= 0) {
            throw new IllegalArgumentException("Количество игр должно быть положительным");
        }
        this.numberOfGames = numberOfGames;
        this.switchDoor = switchDoor;
    }

    public int runGame() {
        int wins = 0;

        for (int i = 0; i < numberOfGames; i++) {
            Game game = new Game();
            Player player = new Player(switchDoor);
            if (player.play(game)) {
                wins++;
            }
        }

        System.out.println("Количество игр: " + numberOfGames);
        System.out.println("Побед с выбранной стратегией: " + wins);
        System.out.println("Процент побед: " + ((double) wins / numberOfGames) * 100 + "%");
        return wins;
    }
}
