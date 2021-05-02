package io.mwkwon.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
}
