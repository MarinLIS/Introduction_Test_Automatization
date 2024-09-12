package homeworks.homework_01;

import java.util.Random;

public class Game {
    private final Door[] doors;
    private final Random random;

    public Game() {
        doors = new Door[3];
        random = new Random();

        for (int i = 0; i < doors.length; i++) {
            doors[i] = new Door(i);
        }

        int prizeDoorIndex = random.nextInt(doors.length);
        doors[prizeDoorIndex].setHasPrize(true);
    }

    public Door getDoor(int index) {
        return doors[index];
    }

    public Door getDoorToReveal(int chosenDoorIndex) {

        if (chosenDoorIndex < 0 || chosenDoorIndex >= doors.length) {
            throw new IllegalArgumentException("Некорректный индекс двери: " + chosenDoorIndex);
        }

        for (Door door : doors) {
            if (!door.hasPrize() && door.getIndex() != chosenDoorIndex) {
                return door;
            }
        }

        return null;
    }
}
