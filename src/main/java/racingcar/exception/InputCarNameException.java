package racingcar.exception;

public class InputCarNameException extends IllegalArgumentException {
    public InputCarNameException() {
        super(ErrorMessage.CAR_NAME_IS_EMPTY.getMessage());
    }
}
