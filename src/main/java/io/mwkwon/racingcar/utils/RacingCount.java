package io.mwkwon.racingcar.utils;

public class RacingCount {

    public static final int MIN_RACING_COUNT = 1;

    private final int count;

    public RacingCount(int count) {
        if (count < MIN_RACING_COUNT) {
            throw new IllegalArgumentException("레이싱 횟수는 0보다 큰값만 입력 가능합니다. 입력값: " + count);
        }
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
