package io.mwkwon.racingcar;

import io.mwkwon.racingcar.utils.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {

    @Test
    @DisplayName("자동차 전진 기능 테스트")
    void carMoveTest() {
        Car car = new Car("myCar");
        RandomNumber randomNumber = new RandomNumber(4);
        car.move(randomNumber);
        int compareTo = car.getMoveDistance().compareTo(new MoveDistance(0));
        assertThat(compareTo).isGreaterThan(0);
    }

    @Test
    @DisplayName("자동차 멈춤 기능 테스트")
    void carStopTest() {
        Car car = new Car("myCar");
        RandomNumber randomNumber = new RandomNumber(3);
        car.move(randomNumber);
        int compareTo = car.getMoveDistance().compareTo(new MoveDistance(0));
        assertThat(compareTo).isEqualTo(0);
    }


    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"carcar", " ", "  "})
    @DisplayName("잘못된 자동차 이름 입력 시 에러 처리 테스트")
    void throwIllegalArgumentExceptionTest(String carName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(carName))
                .withMessageContaining("자동차 이름은 1자 이상 5자 이하만 입력가능합니다.");
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("자동차 이름 null 값 입력 시 에러 처리 테스트")
    void throwNullPointerExceptionTest(String carName) {
        assertThatNullPointerException()
                .isThrownBy(() -> new Car(carName))
                .withMessage("자동차 이름은 null 값을 입력할 수 없습니다.");

    }


    @Test
    @DisplayName("자동차 객체 정상 생성 테스트")
    void crateCarTest() {
        assertThatNoException().isThrownBy(() ->  new Car("myCar"));
    }

    @Test
    @DisplayName("이동 거리 객체를 비교하여 이동 거리가 큰 값을 정상 반환하는지 여부 테스트")
    void findGreaterMoveDistanceTest() {
        MoveDistance moveDistance = new MoveDistance(4);
        Car car = new Car("myCar");
        MoveDistance maximumMoveDistance = car.findGreaterMoveDistance(moveDistance);
        assertThat(maximumMoveDistance.compareTo(moveDistance)).isEqualTo(0);
    }

    @Test
    @DisplayName("이동 거리 객체를 비교하여 같은 이동 거리이면 true 반환 여부 체크 테스트")
    void isSameMoveDistanceTrueTest() {
        MoveDistance moveDistance = new MoveDistance(0);
        Car car = new Car("myCar");
        boolean same = car.isSameMoveDistance(moveDistance);
        assertThat(same).isTrue();
    }

    @Test
    @DisplayName("이동 거리 객체를 비교하여 다른 이동 거리이면 false 반환 여부 체크 테스트")
    void isSameMoveDistanceFalseTest() {
        MoveDistance moveDistance = new MoveDistance(1);
        Car car = new Car("myCar");
        boolean same = car.isSameMoveDistance(moveDistance);
        assertThat(same).isFalse();
    }
}
