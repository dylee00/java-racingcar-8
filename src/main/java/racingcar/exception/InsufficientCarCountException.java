package racingcar.exception;

public class InsufficientCarCountException extends IllegalArgumentException {
    public InsufficientCarCountException() {
        super(ErrorMessage.INSUFFICIENT_CAR_COUNT.getMessage());
    }
}
