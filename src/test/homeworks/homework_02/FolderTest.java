package ru.gb.homeworks.homework_02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FolderTest extends AbstractTest {

    @BeforeAll
    @DisplayName("Начало тестирования")
    public static void globalSetUp() {
        System.out.println("Запуск тестового набора");
    }

    @AfterAll
    @DisplayName("Тестирование завершено")
    public static void globalTearDown() {
        System.out.println("Тесты завершены");
    }

    @Test
    @DisplayName("Проверка добавления и удаления файлов")
    void testAddComponent() {
        // given
        Folder folder = new Folder("TestFolder");
        File file1 = new File("TestFile1.txt");
        File file2 = new File("TestFile1.txt");
        File file3 = new File("TestFile1.txt");
        // when
        folder.addComponent(file1);
        folder.addComponent(file2);
        folder.addComponent(file3);
        folder.removeComponent(file2);
        // then
        assertTrue(folder.getComponents().contains(file1));
        assertFalse(folder.getComponents().contains(file2));
        assertTrue(folder.getComponents().contains(file3));
    }

    @Test
    @DisplayName("Проверка содержимого папки")
    void testFolderContainsFile() {
        // given
        Folder folder = new Folder("TestFolder");
        File file = new File("TestFile1.txt");
        // when
        folder.addComponent(file);
        folder.addComponent(file);
        folder.addComponent(file);
        folder.addComponent(file);
        // then
        assertNotNull(folder);
        assertEquals(4, folder.getComponents().size());
        assertTrue(folder.getComponents().contains(file));
    }

    @ParameterizedTest
    @DisplayName("Проверка названия компонентов")
    @ValueSource(strings = {"File1.txt", "File2.txt", "File3.txt"})
    void testFileNames(String fileName) {
        // given
        // when
        File file = new File(fileName);
        // then
        assertEquals(fileName, file.name);
    }

    @Test
    @DisplayName("Проверка выброса исключения и его типа при удалении несуществующего файла")
    void testRemoveNonExistentComponent() {
        // given
        Folder folder = new Folder("TestFolder");
        File file = new File("Exception.txt");
        // when
        folder.addComponent(file);
        folder.removeComponent(file);
        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            folder.removeComponent(file);
        });
        assertNotNull(exception);
        assertEquals("Нет такой папки или файла", exception.getMessage());
    }
}
