package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RaceManager {
    static final int MOVABLE_NUM = 4;
    public void raceCar(int count, List<String> carNames) {
        //자동차의 이름 -> key, 전진 횟수 -> value
        Map<String, Integer> carPositions = new HashMap<>();
        //초기화
        for(String carName : carNames) {
            carPositions.put(carName, 0);
        }
        System.out.println("실행 결과");
        for(int round = 0; round < count; round++) {
            playOneRound(carPositions);
            printRaceResult(carPositions);
        }
        findWinners(carPositions);
    }

    public void playOneRound(Map<String, Integer> carPositions) {
        for(String carName : carPositions.keySet()) {
            if (isMovable()) {
                carPositions.put(carName, carPositions.get(carName)+1);
            }
        }
    }

    public boolean isMovable() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum < MOVABLE_NUM) {
            return false;
        } else {
            return true;
        }
    }

    public void printRaceResult(Map<String, Integer> carPositions) {
        for(Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            String carName = entry.getKey();
            int position = entry.getValue();
            String progress = "-".repeat(position);
            System.out.println(carName + " : " + progress);
        }
        System.out.println("\n");
    }

    public void findWinners(Map<String, Integer> carPositions) {
        int maxPosition = Collections.max(carPositions.values());
        List<String> winners = findWinnersWithMaxPosition(carPositions, maxPosition);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public List<String> findWinnersWithMaxPosition(Map<String, Integer> carPositions, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            if (entry.getValue() == maxPosition) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }

}