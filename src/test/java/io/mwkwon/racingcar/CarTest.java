package io.mwkwon.racingcar;

import io.mwkwon.racingcar.utils.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 전진 기능 테스트")
    void carMoveTest() {
        Car car = new Car();
        RandomNumber randomNumber = new RandomNumber(4);
        car.move(randomNumber);
        int compareTo = car.getMoveDistance().compareTo(new MoveDistance(0));
        assertThat(compareTo).isGreaterThan(0);
    }

    @Test
    @DisplayName("자동차 멈춤 기능 테스트")
    void carStopTest() {
        Car car = new Car();
        RandomNumber randomNumber = new RandomNumber(3);
        car.move(randomNumber);
        int compareTo = car.getMoveDistance().compareTo(new MoveDistance(0));
        assertThat(compareTo).isEqualTo(0);
    }
}
