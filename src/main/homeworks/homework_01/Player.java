package homeworks.homework_01;

public class Player {
    private final boolean switchDoor;

    public Player(boolean switchDoor) {
        this.switchDoor = switchDoor;
    }

    public boolean play(Game game) {
        // Игрок случайным образом выбирает одну из дверей
        int chosenDoorIndex = (int) (Math.random() * 3);
        Door chosenDoor = game.getDoor(chosenDoorIndex);

        Door revealedDoor = game.getDoorToReveal(chosenDoorIndex);

        if (switchDoor) {
            for (int i = 0; i < 3; i++) {
                if (i != chosenDoorIndex && i != revealedDoor.getIndex()) {
                    chosenDoor = game.getDoor(i);
                    break;
                }
            }
        }

        return chosenDoor.hasPrize();
    }
}
