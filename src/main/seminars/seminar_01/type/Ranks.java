package ru.gb.seminars.seminar_01.type;

/**
 * Значение карты
 */
public enum Ranks {

    TWO("Двойка", 2),
    THREE("Тройка", 3),
    FOUR("Четверка", 4),
    FIVE("Пятерка", 5),
    SIX("Шестерка", 6),
    SEVEN("Семерка", 7),
    EIGHT("Восьмерка", 8),
    NINE("Девятка", 9),
    TEN("Десятка", 10),
    JACK("Валет", 2),
    QUEEN("Дама", 3),
    KING("Король", 4),
    ACE("Туз", 11);

    //Имя карты
    private String name;

    //Вес карты в игре
    private Integer value;

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    Ranks(String name, Integer value) {
        this.name = name;
        this.value = value;
    }


}
