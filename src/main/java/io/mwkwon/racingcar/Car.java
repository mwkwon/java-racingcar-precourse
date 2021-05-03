package io.mwkwon.racingcar;

import io.mwkwon.racingcar.utils.RandomNumber;

public class Car {
    public static final int INIT_MOVE_DISTANCE = 0;

    private final CarName carName;
    private final MoveDistance moveDistance;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.moveDistance = new MoveDistance(INIT_MOVE_DISTANCE);
    }

    public void move(RandomNumber randomNumber) {
        this.moveDistance.move(randomNumber);
    }

    public MoveDistance findGreaterMoveDistance(MoveDistance other) {
        if (this.moveDistance.compareTo(other) < 0) {
            return other;
        }
        return this.moveDistance;
    }

    public boolean isSameMoveDistance(MoveDistance other) {
        return this.moveDistance.compareTo(other) == 0;
    }

    public MoveDistance getMoveDistance() {
        return moveDistance;
    }

    public String printCarName() {
        return carName.toString();
    }

    public String printMoveDistance() {
        return moveDistance.toString();
    }
}
