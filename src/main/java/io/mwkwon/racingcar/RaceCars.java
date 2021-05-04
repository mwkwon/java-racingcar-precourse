package io.mwkwon.racingcar;

import io.mwkwon.racingcar.utils.RacingCarUtil;
import io.mwkwon.racingcar.utils.RandomNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class RaceCars {

    private static final String DELIMITER_ERROR_MESSAGE = "쉼표(',')를 이용하여 차량 이름을 구분하여 입력해 주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = "동일한 자동차 이름이 존재합니다. 입력값: ";
    private static final String CAR_NAME_SIZE_ERROR_MESSAGE = "2대 이상의 차량 이름을 입력해주세요.";

    private List<Car> cars;

    public RaceCars(String carNames) {
        String[] carNameArray = this.createCarNameArray(carNames);
        carNameArray = this.trimCarNames(carNameArray);
        this.checkDuplicateString(carNameArray);
        this.checkCarNameSize(carNameArray);
        this.cars = this.createCars(carNameArray);
    }

    public RaceCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    private String[] trimCarNames(String[] carNameArray) {
        String[] trimCarNameArray = new String[carNameArray.length];
        for (int i = 0; i < carNameArray.length; i++) {
            trimCarNameArray[i] = carNameArray[i].trim();
        }
        return trimCarNameArray;
    }

    public void race(RacingCarUtil racingCarUtil) {
        for (Car car : cars) {
            RandomNumber randomNumber = racingCarUtil.generatorRandomNumber();
            car.move(randomNumber);
        }
    }

    public MoveDistance findMaximumMoveDistance() {
        MoveDistance maxMoveDistance = new MoveDistance(0);
        for (Car car : cars) {
            maxMoveDistance = car.findGreaterMoveDistance(maxMoveDistance);
        }
        return maxMoveDistance;
    }

    public RaceCars findWinnerCars(MoveDistance maximumMoveDistance) {
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            boolean same = car.isSameMoveDistance(maximumMoveDistance);
            this.addWinnerCarsBySameIsTrue(winnerCars, same, car);
        }
        return new RaceCars(winnerCars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> createWinnerCarNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.generatePrintCarName());
        }
        return carNames;
    }

    private List<Car> createCars(String[] carNameArray) {
        List<Car> cars = new ArrayList<>();
        for (String s : carNameArray) {
            Car car = new Car(s);
            cars.add(car);
        }
        return cars;
    }

    private String[] createCarNameArray(String carNames) {
        this.checkDelimiter(carNames);
        return carNames.split(Constants.COMMA_DELIMITER);
    }

    private void checkCarNameSize(String[] carNames) {
        if (carNames.length <= 1) {
            throw new IllegalArgumentException(CAR_NAME_SIZE_ERROR_MESSAGE);
        }
    }

    private void checkDuplicateString(String[] carNameArray) {
        Set<String> cars = new HashSet<>(Arrays.asList(carNameArray));
        if (cars.size() < carNameArray.length) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE +
                    String.join(Constants.COMMA_DELIMITER, carNameArray));
        }
    }

    private void checkDelimiter(String carNames) {
        if (!carNames.contains(Constants.COMMA_DELIMITER)) {
            throw new IllegalArgumentException(DELIMITER_ERROR_MESSAGE);
        }
    }

    private void addWinnerCarsBySameIsTrue(List<Car> winnerCars, boolean same, Car car) {
        if (same) {
            winnerCars.add(car);
        }
    }
}
