package io.mwkwon.racingcar.utils;

import io.mwkwon.racingcar.Car;
import io.mwkwon.racingcar.Constants;
import io.mwkwon.racingcar.RaceCars;

import java.util.Random;
import java.util.Scanner;

public class RacingCarUtil implements RandomGenerator {

    private static final String PRINT_REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PRINT_REQUEST_RACING_COUNT = "시도할 회수는 몇회 인가요?";
    private static final String PRINT_WINNER_CARS = "가 최종 우승했습니다.";
    private static final String PRINT_RACE_RESULT = "실행 결과";

    private Scanner scanner = new Scanner(System.in);

    @Override
    public RandomNumber generatorRandomNumber() {
        int number = new Random().nextInt(Constants.RANDOM_NUMBER_BOUND);
        return new RandomNumber(number);
    }

    public RaceCars requestRaceCarName() {
        System.out.println(PRINT_REQUEST_CAR_NAME);
        String carNames = scanner.nextLine();
        return new RaceCars(carNames);
    }

    public RacingCount requestRacingCount() {
        System.out.println(PRINT_REQUEST_RACING_COUNT);
        int count = scanner.nextInt();
        return new RacingCount(count);
    }

    public void printRaceResult(RaceCars raceCars) {
        System.out.println(PRINT_RACE_RESULT);
        for (Car car : raceCars.getCars()) {
            System.out.println(car.generateRaceResultPrintString());
        }
        System.out.println();
    }
    public void printWinnerCars(RaceCars raceCars) {
        System.out.println(String.join(Constants.COMMA_DELIMITER, raceCars.createWinnerCarNames()) + PRINT_WINNER_CARS);
    }

}
