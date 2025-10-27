package racingcar.exception;

public class InvalidRaceCountException extends IllegalArgumentException {
    public InvalidRaceCountException() {
        super(ErrorMessage.INVALID_RACE_COUNT.getMessage());
    }
}
