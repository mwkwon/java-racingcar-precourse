package io.mwkwon.racingcar;

import io.mwkwon.racingcar.utils.RandomNumber;

public class MoveDistance implements Comparable<MoveDistance> {
    private static final int MIN_MOVE_NUMBER = 4;
    private static final String STRING_DISTANCE = "-";
    private static final String EMPTY_STRING = "";

    private int distance;

    public MoveDistance(int distance) {
        this.distance = distance;
    }

    public void move(RandomNumber randomNumber) {
        if (randomNumber.compareTo(MIN_MOVE_NUMBER) >= 0) {
            this.distance++;
        }
    }

    @Override
    public int compareTo(MoveDistance other) {
        return this.distance - other.distance;
    }

    @Override
    public String toString() {
        String stringDistance = EMPTY_STRING;
        for (int i = 0; i < distance; i++) {
            stringDistance += STRING_DISTANCE;
        }
        return stringDistance;
    }
}
