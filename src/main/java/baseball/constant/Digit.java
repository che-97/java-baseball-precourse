package baseball.constant;

public enum Digit {
    START_RANGE(1),
    END_RANGE(9),
    LENGTH(3);

    private final int number;

    Digit(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
