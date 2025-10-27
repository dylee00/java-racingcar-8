package racingcar;

import racingcar.exception.CarNameLengthException;
import racingcar.race.RaceManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        List<String> carNames = Arrays.asList(input.split(","));

        for(String carName : carNames) {
            if (carName.length() > 5) {
                throw new CarNameLengthException();
            }
        }


        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = scanner.nextInt();

        scanner.close();

        //자동차 경주 실행
        RaceManager raceManager = new RaceManager();
        raceManager.raceCar(count, carNames);

    }
}
