package ru.gb.lessons.lesson_02.solid;

/**
 * Класс датчик - совмещает в себе как функции датчика температуры так и функции датчика задымления
 */
public class SuperSensor {

    private int temperatureValueActual;
    private int temperatureValueMax;
    private int smokeValueActual;
    private int smokeValueMax;
    private boolean alarm;


    public SuperSensor(int temperatureValueMax, int smokeValueMax) {
        this.temperatureValueMax = temperatureValueMax;
        this.smokeValueMax = smokeValueMax;
    }

    //Датчик получает показания температуры
    public void getTemperatureSignal(int signal) {
        this.temperatureValueActual = signal;
        setAlarm(checkAlert(signal, temperatureValueMax), "температура");
    }

    //Датчик получает показания дыма
    public void getSmokeSignal(int signal) {
        this.smokeValueActual = signal;
        setAlarm(checkAlert(signal, smokeValueMax), "дым");
    }

    //Проверка, что предельные значения не превышены
    private boolean checkAlert (int value, int max) {
        if (value > max) return true;
        return false;
    }

    //Включения сигнализации
    private void setAlarm (boolean alert, String value) {
        if(alert) {
            alarm = true;
            System.out.println("Обнаружено повышение показателя: " + value);
        }
    }

    public boolean isAlarm() {
        return alarm;
    }
}
