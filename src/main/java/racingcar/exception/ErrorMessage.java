package racingcar.exception;

public enum ErrorMessage {
    CAR_NAME_TOO_LONG("자동차의 이름이 5글자 이상입니다."),
    CAR_NAME_IS_EMPTY("자동차의 이름을 입력하세요"),
    INSUFFICIENT_CAR_COUNT("경주에는 최소 2대의 자동차가 필요합니다. 적절한 값을 입력해 주세요."),
    INVALID_CAR_NAME("자동차 이름을 쉼표(,)로 구분해서 적절한 값을 입력해주세요."),
    INVALID_RACE_COUNT("시도 횟수는 1 이상이어야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
