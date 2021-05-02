package io.mwkwon.racingcar.utils;

import io.mwkwon.racingcar.RaceCars;

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
}
