package baseball.constant;

public enum ErrorMessage {
    NOT_NUMBER("숫자가 아닙니다."),
    NOT_IN_RANGE("범위 내의 숫자가 아닙니다."),
    DUPLICATE_EXISTS("중복된 수가 있습니다."),
    WRONG_RESERVED_WORD("잘못된 선택입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
