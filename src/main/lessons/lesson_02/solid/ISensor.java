package ru.gb.lessons.lesson_02.solid;

/**
 * Интерфейс датчиков
 */
public interface ISensor {

    public void getSignal(int signal);

    default boolean checkAlert (int value, int maxValue) {
        if (value > maxValue) return true;
        return false;
    }

    public void setAlarm (boolean alert, String value);

    public Boolean isAlarm ();
}
