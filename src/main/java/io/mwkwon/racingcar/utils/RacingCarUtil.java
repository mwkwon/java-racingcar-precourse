package io.mwkwon.racingcar.utils;

import io.mwkwon.racingcar.Car;
import io.mwkwon.racingcar.RaceCars;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCarUtil implements RandomGenerator {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public RandomNumber generatorRandomNumber() {
        int number = new Random().nextInt(RandomNumber.RANDOM_NUMBER_BOUND);
        return new RandomNumber(number);
    }

    public RaceCars requestRaceCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = scanner.nextLine();
        return new RaceCars(carNames);
    }

    public RacingCount requestRacingCount() {
        System.out.println("시도할 회수는 몇회 인가요?");
        int count = scanner.nextInt();
        return new RacingCount(count);
    }

    public void printRaceResult(RaceCars raceCars) {
        System.out.println("실행 결과");
        for (Car car : raceCars.getCars()) {
            System.out.println(car.printCarName() + ":" + car.printMoveDistance());
        }
        System.out.println("");
    }
    public void printWinnerCars(RaceCars raceCars) {
        System.out.println(String.join(RaceCars.DELIMITER, raceCars.carNames()) + "가 최종 우승했습니다.");
    }

}
