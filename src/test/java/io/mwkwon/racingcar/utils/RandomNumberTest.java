package io.mwkwon.racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberTest {

    @ParameterizedTest
    @DisplayName("원시값 포장 랜덤값 0보다 작거나 9보다 큰값 입력 시 에러 정상 발생 여부 테스트")
    @ValueSource(ints = {-1, 10})
    void throwIllegalArgumentsExceptionByTest(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RandomNumber(number)).withMessage("0에서 9사이 값만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("원시값 포장 랜덤값 객체 정상 생성 테스트")
    void createRandomNumberTest(int number) {
        RandomNumber randomNumber = new RandomNumber(number);
        assertThat(randomNumber.getNumber()).isEqualTo(number);
    }
}
