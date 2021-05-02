package io.mwkwon.racingcar.utils;

import java.util.Random;

public class RacingCarUtil implements RandomGenerator {

    @Override
    public RandomNumber generatorRandomNumber() {
        int number = new Random().nextInt(RandomNumber.RANDOM_NUMBER_BOUND);
        return new RandomNumber(number);
    }
}
