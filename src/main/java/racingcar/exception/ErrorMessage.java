package racingcar.exception;

public enum ErrorMessage {
    CAR_NAME_TOO_LONG("자동차의 이름이 5글자 이상입니다."),
    CAR_NAME_IS_EMPTY("자동차의 이름을 입력하세요"),
    INVALID_RACE_COUNT("시도 횟수는 1 이상이어야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
