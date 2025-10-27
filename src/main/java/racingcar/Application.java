package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.*;
import racingcar.race.RaceManager;

import java.util.Arrays;
import java.util.List;

public class Application {
    static final int MAX_CAR_NAME_LENGTH = 5;
    static final String DEFAULT_DELIMITER= ",";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();

        if(!inputCarNames.contains(DEFAULT_DELIMITER)) {
            throw new InvalidCarNameException();
        }

        List<String> carNames = Arrays.asList(inputCarNames.split(DEFAULT_DELIMITER));

        if (carNames.size() < 2) {
            throw new InsufficientCarCountException();
        }

        for(String carName : carNames) {
            if (carName.isBlank()) {
                throw new InputCarNameException();
            }else if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new CarNameLengthException();
            }
        }

        long distinctCount = carNames.stream().map(String::trim).distinct().count();
        if(distinctCount != carNames.size()) {
            throw new DuplicateCarNameException();
        }

        System.out.println("시도할 횟수는 몇 회인가요?");

        String inputCount = Console.readLine();
        if(inputCount.isBlank()) {
            throw new InvalidRaceCountException();
        }

        int raceCount;

        try {
            raceCount = Integer.parseInt(inputCount);
        } catch (NumberFormatException e) {
            throw new InvalidRaceCountException();
        }

        if(raceCount < 1) {
            throw new InvalidRaceCountException();
        }

        Console.close();

        //자동차 경주 실행
        RaceManager raceManager = new RaceManager();
        raceManager.raceCar(raceCount, carNames);
    }
}
