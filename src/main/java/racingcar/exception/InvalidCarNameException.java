package racingcar.exception;

public class InvalidCarNameException extends IllegalArgumentException {
    public InvalidCarNameException() {
        super(ErrorMessage.INVALID_CAR_NAME.getMessage());
    }
}
