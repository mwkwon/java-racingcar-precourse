package io.mwkwon.racingcar.utils;

public class RacingCount {

    private static final int MIN_RACING_COUNT = 1;
    private static final String ERROR_MESSAGE = "레이싱 횟수는 0보다 큰값만 입력 가능합니다. 입력값: ";

    private final int count;

    public RacingCount(int count) {
        if (count < MIN_RACING_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + count);
        }
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
