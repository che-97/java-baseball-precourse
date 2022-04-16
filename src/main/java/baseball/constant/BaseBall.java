package baseball.constant;

public enum BaseBall {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String string;

    BaseBall(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
