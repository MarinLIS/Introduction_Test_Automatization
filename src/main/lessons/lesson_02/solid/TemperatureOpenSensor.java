package ru.gb.lessons.lesson_02.solid;

/**
 * Датчик температуры - пример с функционалом sms оповещения
 */
public class TemperatureOpenSensor implements ISensor{

    private int valueActual;
    private int smsSend;

    public TemperatureOpenSensor(int valueMax) {
        this.valueMax = valueMax;
    }

    private int valueMax;

    @Override
    public void getSignal(int signal) {
        this.valueActual = check(signal);
        setAlarm(checkAlert(signal, valueMax), "температура");
    }

    private int check(int signal) {
        return signal * 10;

    }

    @Override
    public void setAlarm(boolean alert, String value) {

    }

    @Override
    public Boolean isAlarm() {
        return checkAlert(valueActual, valueMax);
    }

    public void sendSms() {
        smsSend++;
    }

    public int getSmsSend() {
        return smsSend;
    }


}
