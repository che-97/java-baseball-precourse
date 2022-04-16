package baseball.constant;

public enum ReservedWord {
    RESTART(1),
    STOP(2);

    private final int number;

    ReservedWord(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
