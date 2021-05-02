package io.mwkwon.racingcar.utils;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RacingCarUtil implements RandomGenerator {

    private Scanner scanner = new Scanner(System.in);
    private static final int MAX_ERROR_COUNT = 5;
    private int errorCnt;

    @Override
    public RandomNumber generatorRandomNumber() {
        int number = new Random().nextInt(RandomNumber.RANDOM_NUMBER_BOUND);
        return new RandomNumber(number);
    }

    public RacingCount requestRacingCount() {
        int count = 0;
        try {
            count = scanner.nextInt();
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("입력값을 확인해주세요. 0보다 큰 숫자만 입력 가능합니다. 입력값: " + count);
            this.checkErrorCount();
            this.requestRacingCount();
        }
        this.errorCnt = 0;
        return new RacingCount(count);
    }

    private void checkErrorCount() {
        this.errorCnt++;
        if (errorCnt >= MAX_ERROR_COUNT) {
            System.out.println("잘못된 입력값이 5회 입력되었습니다. 프로그램을 종료합니다.");
            System.exit(1);
        }
    }
}
