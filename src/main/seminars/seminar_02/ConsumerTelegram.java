package ru.gb.seminars.seminar_02;

/**
 * Реализация интерфейса IConsumer
 */
public class ConsumerTelegram implements IConsumer{

    private boolean free = true;

    @Override
    public Status sendMessage(String str) {
        if(free) return Status.OK;
        return Status.WARNING;
    }

    @Override
    public boolean isLineFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
