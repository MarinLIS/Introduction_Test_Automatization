package homeworks.homework_01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MontyHallParadoxTest extends AbstractTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("Проверка выброса исключения и его сообщения при передаче в качестве количества игр ноль или отрицательного")
    void testInvalidNumberOfGames(int invalidNumberOfGames) {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new MontyHallParadox(invalidNumberOfGames, true);
        });
        assertNotNull(exception);
        assertEquals("Количество игр должно быть положительным", exception.getMessage());
    }

    @Test
    @DisplayName("Попытка открыть несуществующую дверь")
    void testGetInvalidDoor() {
        // given
        Game game = new Game();

        // when
        // ArrayIndexOutOfBoundsException.

        // then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> game.getDoor(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, -1})
    @DisplayName("Проверка на выбор некорректного индекса двери для открытия")
    void testInvalidDoorToReveal(int invalidIndex) {
        // given
        Game game = new Game();

        // when
        // IllegalArgumentException

        // then
        assertThrows(IllegalArgumentException.class, () -> game.getDoorToReveal(invalidIndex));
    }

    @Test
    @DisplayName("Проверка состояния дверей после игры")
    void testDoorStateAfterGame() {
        // given
        Game game = new Game();
        Player player = new Player(true);

        // when
        // then
        for (int i = 0; i < 3; i++) {
            assertNotNull(game.getDoor(i));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("Проверка разных комбинаций выбора дверей")
    void testDifferentDoorCombinations(int chosenDoorIndex) {
        // given
        Game game = new Game();

        // when
        Door chosenDoor = game.getDoor(chosenDoorIndex);
        Door revealedDoor = game.getDoorToReveal(chosenDoorIndex);

        // then
        assertNotEquals(chosenDoor.getIndex(), revealedDoor.getIndex()); // выбранная != открытая
        assertFalse(revealedDoor.hasPrize()); // коза
    }

    @Test
    @DisplayName("Проверка создания двери и изменения её состояния")
    void testDoorCreationAndState() {
        // given
        Door door = new Door(0);

        // when
        door.setHasPrize(true);

        // then
        assertEquals(0, door.getIndex());
        assertTrue(door.hasPrize());
    }

    @Test
    @DisplayName("Проверка вероятности победы со сменой двери")
    void testSwitchDoorBehavior() {
        // given
        MontyHallParadox simulation = new MontyHallParadox(1000, true);

        // when
        int wins = simulation.runGame();
        double winRate = (double) wins / 1000;

        // then
        assertTrue(winRate > 0.6);
    }

    @Test
    @DisplayName("Проверка вероятности победы без смены двери")
    void testNoSwitchDoorBehavior() {
        // given
        MontyHallParadox simulation = new MontyHallParadox(1000, false);

        // when
        int wins = simulation.runGame();
        double winRate = (double) wins / 1000;

        // then
        assertTrue(winRate < 0.4);
    }
}
