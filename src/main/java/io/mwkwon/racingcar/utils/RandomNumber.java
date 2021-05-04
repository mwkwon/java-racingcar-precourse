package io.mwkwon.racingcar.utils;

public class RandomNumber implements Comparable<Integer>{

    private static final int MAX_RANDOM_NUM = 9;
    private static final int MIN_RANDOM_NUM = 0;
    private static final String ERROR_MESSAGE = "0에서 9사이 값만 입력 가능합니다.";

    private final int number;

    public RandomNumber(int number) {
        if (number < MIN_RANDOM_NUM || number > MAX_RANDOM_NUM) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        this.number = number;
    }

    @Override
    public int compareTo(Integer other) {
        return number - other;
    }
}
