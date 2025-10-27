package racingcar.exception;

public class InValidCarNameException extends IllegalArgumentException {
    public InValidCarNameException() {
        super(ErrorMessage.INVALID_CAR_NAME.getMessage());
    }
}
