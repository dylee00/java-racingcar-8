package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.CarNameLengthException;
import racingcar.exception.InputCarNameException;
import racingcar.exception.InvalidRaceCountException;
import racingcar.race.RaceManager;

import java.util.Arrays;
import java.util.List;

public class Application {
    static final int MAX_CAR_NAME_LENGTH = 5;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        List<String> carNames = Arrays.asList(inputCarNames.split(","));

        for(String carName : carNames) {
            if (carName.isEmpty()) {
                throw new InputCarNameException();
            }else if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new CarNameLengthException();
            }
        }

        System.out.println("시도할 횟수는 몇 회인가요?");

        String inputCount = Console.readLine();
        if(inputCount.isEmpty()) {
            throw new InvalidRaceCountException();
        }

        int count = Integer.parseInt(Console.readLine());
        if(count < 1) {
            throw new InvalidRaceCountException();
        }

        Console.close();

        //자동차 경주 실행
        RaceManager raceManager = new RaceManager();
        raceManager.raceCar(count, carNames);

    }
}
