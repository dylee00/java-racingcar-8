package racingcar.exception;

public class CarNameLengthException extends IllegalArgumentException {
    public CarNameLengthException() {
        super(ErrorMessage.CAR_NAME_TOO_LONG.getMessage());
    }
}
