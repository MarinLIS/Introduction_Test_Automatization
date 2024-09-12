package homeworks.homework_01;

public class Door {
    private final int index;
    private boolean hasPrize;

    public Door(int index) {
        this.index = index;
        this.hasPrize = false;
    }

    public void setHasPrize(boolean hasPrize) {
        this.hasPrize = hasPrize;
    }

    public int getIndex() {
        return index;
    }

    public boolean hasPrize() {
        return hasPrize;
    }
}
