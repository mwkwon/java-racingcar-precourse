package io.mwkwon.racingcar;

import io.mwkwon.racingcar.utils.RandomNumber;

public class MoveDistance implements Comparable<MoveDistance> {
    public static final int MIN_MOVE_NUMBER = 4;

    private int distance;

    public MoveDistance(int distance) {
        this.distance = distance;
    }

    public void move(RandomNumber randomNumber) {
        if (randomNumber.getNumber() >= MIN_MOVE_NUMBER) {
            this.distance++;
        }
    }

    @Override
    public int compareTo(MoveDistance other) {
        return this.distance - other.distance;
    }

    @Override
    public String toString() {
        String strDistance = "";
        for (int i = 0; i < distance; i++) {
            strDistance += "-";
        }
        return strDistance;
    }
}
