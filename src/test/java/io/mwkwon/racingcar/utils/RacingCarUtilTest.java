package io.mwkwon.racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


class RacingCarUtilTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤 값 정상 생성 여부 테스트")
    void requestRacingCountTest(int number) {
        RacingCarUtil racingCarUtil = new RacingCarUtil() {
            @Override
            public RandomNumber generatorRandomNumber() {
                return new RandomNumber(number);
            }
        };
        RandomNumber randomNumber = racingCarUtil.generatorRandomNumber();
        assertThat(randomNumber.getNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("랜덤 값 비정상 생성 시 에러 발생 여부 테스트")
    void throwExceptionTest(int number) {
        RacingCarUtil racingCarUtil = new RacingCarUtil() {
            @Override
            public RandomNumber generatorRandomNumber() {
                return new RandomNumber(number);
            }
        };
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> racingCarUtil.generatorRandomNumber())
                .withMessage("0에서 9사이 값만 입력 가능합니다.");
    }
}
