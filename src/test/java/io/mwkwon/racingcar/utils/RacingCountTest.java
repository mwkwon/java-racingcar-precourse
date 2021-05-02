package io.mwkwon.racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class RacingCountTest {

    @ParameterizedTest
    @DisplayName("레이싱 횟수 객체 생성시 0과 같거나 작은값 입력 시 에러 처리 테스트")
    @ValueSource(ints = {0, -1})
    void throwExceptionTest(int count) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingCount(count))
                .withMessageContaining("레이싱 횟수는 0보다 큰값만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, Integer.MAX_VALUE})
    @DisplayName("레이싱 횟수 객체 정상 생성 테스트")
    void createRacingCountTest(int count) {
        RacingCount racingCount = new RacingCount(count);
        assertThat(racingCount.getCount()).isEqualTo(count);
    }
}
