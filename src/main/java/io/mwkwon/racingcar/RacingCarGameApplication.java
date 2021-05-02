package io.mwkwon.racingcar;

import io.mwkwon.racingcar.utils.RacingCarUtil;
import io.mwkwon.racingcar.utils.RacingCount;

import java.util.List;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        RacingCarUtil racingCarUtil = new RacingCarUtil();
        RaceCars raceCars = racingCarUtil.requestRaceCarName();
        RacingCount racingCount = racingCarUtil.requestRacingCount();
        for (int i = 0; i < racingCount.getCount(); i++) {
            raceCars.race(racingCarUtil);
        }
        MoveDistance maximumMoveDistance = raceCars.findMaximumMoveDistance();
        List<Car> winnerCars = raceCars.findWinnerCars(maximumMoveDistance);
    }
}
