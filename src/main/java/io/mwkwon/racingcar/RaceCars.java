package io.mwkwon.racingcar;

import io.mwkwon.racingcar.utils.RacingCarUtil;
import io.mwkwon.racingcar.utils.RandomNumber;

import java.util.*;

public class RaceCars {
    public static  final String DELIMITER = ",";
    private List<Car> cars;

    public RaceCars(String carNames) {
        String[] carNameArray = this.createCarNameArray(carNames);
        carNameArray = this.trimCarNames(carNameArray);
        this.checkDuplicateString(carNameArray);
        this.checkCarNameSize(carNameArray);
        this.cars = this.createCars(carNameArray);
    }

    private String[] trimCarNames(String[] carNameArray) {
        String[] trimCarNameArray = new String[carNameArray.length];
        for (int i = 0; i < carNameArray.length; i++) {
            trimCarNameArray[i] = carNameArray[i].trim();
        }
        return trimCarNameArray;
    }

    public RaceCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
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

    public List<String> carNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.printCarName());
        }
        return carNames;
    }

    private List<Car> createCars(String[] carNameArray) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNameArray.length; i++) {
            Car car = new Car(carNameArray[i]);
            cars.add(car);
        }
        return cars;
    }

    private String[] createCarNameArray(String carNames) {
        this.checkDelimiter(carNames);
        return carNames.split(DELIMITER);
    }

    private void checkCarNameSize(String[] carNames) {
        if (carNames.length <= 1) {
            throw new IllegalArgumentException("2대 이상의 차량 이름을 입력해주세요.");
        }
    }

    private void checkDuplicateString(String[] carNameArray) {
        Set<String> cars = new HashSet<>();
        for (int i = 0; i < carNameArray.length; i++) {
            cars.add(carNameArray[i]);
        }
        if (cars.size() < carNameArray.length) {
            throw new IllegalArgumentException("동일한 자동차 이름이 존재합니다. 입력값: "
                    + String.join(DELIMITER, carNameArray));
        }
    }

    private void checkDelimiter(String carNames) {
        if (!carNames.contains(DELIMITER)) {
            throw new IllegalArgumentException("쉼표(',')를 이용하여 차량 이름을 구분하여 입력해 주세요.");
        }
    }

    private void addWinnerCarsBySameIsTrue(List<Car> winnerCars, boolean same, Car car) {
        if (same) {
            winnerCars.add(car);
        }
    }
}
