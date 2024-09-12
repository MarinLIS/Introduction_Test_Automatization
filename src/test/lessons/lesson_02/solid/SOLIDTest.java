package ru.gb.lessons.lesson_02.solid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SOLIDTest {

    @Test
    @DisplayName("Сомнительное решение через SuperSensor")
    void testSuperSensorSingleResponsibility() {
        //given
        SuperSensor sensor = new SuperSensor(10, 100);
        //when
        sensor.getSmokeSignal(150);
        sensor.getTemperatureSignal(15);
        //then
        Assertions.assertTrue(sensor.isAlarm());

    }

    @Test
    @DisplayName("Правильное решение через ISensor")
    void testSensorsSingleResponsibility() {
        //given
        ISensor sensorTemperature = new TemperatureSensor(100);
        ISensor sensorSmoke = new SmokeSensor(100, false);
        //when
        sensorTemperature.getSignal(3);
        sensorSmoke.getSignal(10);
        //then
        Assertions.assertFalse(sensorTemperature.isAlarm());
        Assertions.assertFalse(sensorSmoke.isAlarm());

    }

    @Test
    void testOpenClosed() {
        //given
        TemperatureOpenSensor sensor = new TemperatureOpenSensor(100);
        //when
        sensor.getSignal(13);
        if(sensor.isAlarm()) sensor.sendSms();
        //then
        Assertions.assertTrue(sensor.isAlarm());
        Assertions.assertTrue(sensor.getSmsSend() > 0);

    }

    @Test
    void testLiskov() {
        //given
        ISensor sensor = new ColdSensor(100);
        //when
        sensor.getSignal(13);
        //then
        Assertions.assertNull(sensor.isAlarm());

    }
}
