package io.mwkwon.racingcar;

import io.mwkwon.racingcar.utils.RandomNumber;

public class Car {
    public static final int INIT_MOVE_DISTANCE = 0;

    private final MoveDistance moveDistance;

    public Car() {
        this.moveDistance = new MoveDistance(INIT_MOVE_DISTANCE);
    }

    public void move(RandomNumber randomNumber) {
        this.moveDistance.move(randomNumber);
    }

    public MoveDistance getMoveDistance() {
        return moveDistance;
    }
}
