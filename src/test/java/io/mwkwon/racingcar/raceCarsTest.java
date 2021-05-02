package io.mwkwon.racingcar;

import io.mwkwon.racingcar.utils.RacingCarUtil;
import io.mwkwon.racingcar.utils.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class raceCarsTest {


    @Test
    @DisplayName("경주 자동차 일급 컬렉션 객체 정상 생성 여부 확인")
    void createRaceCarsTest() {
        RaceCars raceCars = new RaceCars("car1, car2");
        List<Car> cars = raceCars.getCars();
        assertThat(cars.size()).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("','로 구분되어있지않는 문자열 입력 시 에러 처리 테스트")
    @ValueSource(strings = {"car1:car2", "car1car2"})
    void throwExceptionByCarNameDelimiterTest(String carNames) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RaceCars(carNames))
                .withMessageContaining("','");
    }

    @Test
    @DisplayName("동일한 이름 값 입력 시 에러 처리 테스트")
    void throwExceptionByDuplicateCarNameTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RaceCars("car1, car1"))
                .withMessageContaining("동일한 자동차 이름이 존재합니다.");
    }

    @Test
    @DisplayName("1대의 자동차 이름을 입력 시 에러 처리 테스트")
    void throwExceptionByOneCarNameTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RaceCars("car1,"))
                .withMessageContaining("2대 이상의 차량 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"car1,car2:4:0:1", "car1,car2:3:0:0"}, delimiter = ':')
    @DisplayName("입력한 자동차 경주 기능 테스트")
    void raceTest(String carNames, int randomNumber, int distance, int excepted) {
        RaceCars raceCars = new RaceCars(carNames);
        RacingCarUtil racingCarUtil = new RacingCarUtil() {
            @Override
            public RandomNumber generatorRandomNumber() {
                return new RandomNumber(randomNumber);
            }
        };
        raceCars.race(racingCarUtil);
        for (Car car : raceCars.getCars()) {
            MoveDistance moveDistance = car.getMoveDistance();
            int compareTo = moveDistance.compareTo(new MoveDistance(distance));
            assertThat(compareTo).isEqualTo(excepted);
        }
    }

    @Test
    @DisplayName("자동차들의 이동 거리를 비교하여 최대 이동 거리 반환 테스트")
    void findMaximumMoveDistanceTest() {
        MoveDistance moveDistance = new MoveDistance(1);
        RaceCars raceCars = new RaceCars("car1,car2,car3");

        raceCars.race(new RacingCarUtil());
        MoveDistance maximumMoveDistance = raceCars.findMaximumMoveDistance();

        assertThat(moveDistance.compareTo(maximumMoveDistance)).isEqualTo(0);
    }

    @Test
    @DisplayName("우승자 판별 테스트 테스트")
    void findWinnerCarTest() {
        MoveDistance moveDistance = new MoveDistance(1);
        RaceCars raceCars = new RaceCars("car1,car2,car3");

        raceCars.race(new RacingCarUtil());
        MoveDistance maximumMoveDistance = raceCars.findMaximumMoveDistance();
        List<Car> winnerCars = raceCars.findWinnerCars(maximumMoveDistance);

        for (Car winnerCar : winnerCars) {
            int compareTo = winnerCar.getMoveDistance().compareTo(moveDistance);
            assertThat(compareTo).isEqualTo(0);
        }
    }
}
