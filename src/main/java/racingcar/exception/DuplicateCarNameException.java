package racingcar.exception;

public class DuplicateCarNameException extends IllegalArgumentException {
    public DuplicateCarNameException() {
        super(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
    }
}
