package baseball.constant;

public enum Hint {
    HINT_ASK_INPUT("숫자를 입력해주세요 : "),
    HINT_GAME_OVER(
        Digit.LENGTH.getNumber() + "개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    HINT_RESTART(
        "게임을 새로 시작하려면 " + ReservedWord.RESTART.getNumber()
            + ", 종료하려면 " + ReservedWord.STOP.getNumber() + "를 입력하세요");

    private final String message;

    Hint(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
