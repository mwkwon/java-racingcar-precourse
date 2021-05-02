package io.mwkwon.racingcar;

import io.mwkwon.racingcar.utils.RandomNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoveDistanceTest {

    private MoveDistance moveDistance;

    @BeforeEach
    void setUp() {
        moveDistance = new MoveDistance(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("입력값 4 이상 이동 테스트")
    void moveByGreaterThanOrEqualTo4Test(int randomNumber) {
        moveDistance.move(new RandomNumber(randomNumber));
        int compareTo = moveDistance.compareTo(new MoveDistance(0));
        assertThat(compareTo).isGreaterThan(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("입력값 3이하 멈춤 테스트")
    void stopByLessThanOrEqualTo3Test(int randomNumber) {
        moveDistance.move(new RandomNumber(randomNumber));
        int compareTo = moveDistance.compareTo(new MoveDistance(0));
        assertThat(compareTo).isEqualTo(0);
    }

    @Test
    @DisplayName("두개의 moveDistance 객체 비교 시 other 객체가 더 큰지 확인 테스트")
    void compareToLessThanTest() {
        moveDistance.move(new RandomNumber(4));
        MoveDistance other = new MoveDistance(2);
        int compareTo = moveDistance.compareTo(other);
        assertThat(compareTo).isLessThan(0);
    }
}
