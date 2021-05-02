package io.mwkwon.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarNameTest {
    @Test
    @DisplayName("자동차 이름 원시값 포장 객체 생성 테스트")
    void createGarNameTest() {
        CarName carName = new CarName("abce");
        String name = carName.getName();
        assertThat(name).isEqualTo("abce");
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 유효하지 않은 값 입력 시 에러 발생 테스트")
    @EmptySource
    @ValueSource(strings = {"qwerts", " ", "  "})
    void throwIllegalArgumentExceptionTest(String carName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName(carName))
                .withMessageContaining("자동차 이름은 1자 이상 5자 이하만 입력가능합니다");
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("자동차 이름 NULL값 입력 시 에러 발생 처리 테스트")
    void throwNullPointerExceptionTest(String carName) {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new CarName(carName))
                .withMessage("자동차 이름은 null 값을 입력할 수 없습니다.");
    }
}
