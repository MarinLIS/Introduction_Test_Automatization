package ru.gb.lessons.lesson_02.solid;

/**
 * Датчик дыма
 */
public class SmokeSensor implements ISensor{

    private int valueActual;

    public SmokeSensor(int valueMax, boolean alarm) {
        this.valueMax = valueMax;
        this.alarm = alarm;
    }

    private int valueMax;
    public boolean alarm;

    @Override
    public void getSignal(int signal) {
        valueActual = signal;
        setAlarm(checkAlert(signal, valueMax), "дым");
    }

    @Override
    public void setAlarm(boolean alert, String value) {
        if(alert) {
            alarm = true;
            System.out.println("Обнаружено повышение показателя: " + value);
        }
    }

    @Override
    public Boolean isAlarm() {
        return alarm;
    }
}
