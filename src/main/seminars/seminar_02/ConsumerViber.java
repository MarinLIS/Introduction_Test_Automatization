package ru.gb.seminars.seminar_02;

/**
 * Реализация интерфейса IConsumer
 */
public class ConsumerViber implements IConsumer{

    private boolean free = true;

    @Override
    public Status sendMessage(String str) {
        if(free){
            free = false;
            return Status.OK;
        }
        return Status.ERROR;
    }

    @Override
    public boolean isLineFree() {
        return free;
    }
}
