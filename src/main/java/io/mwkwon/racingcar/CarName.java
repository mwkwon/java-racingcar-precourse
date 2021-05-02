package io.mwkwon.racingcar;

public class CarName {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MIN_CAR_NAME_LENGTH = 1;

    private String name;

    public CarName(String name) {
        this.checkNull(name);
        this.checkCarNameLength(name);
        this.name = name;
    }

    private void checkCarNameLength(String name) {
        int nameLength = name.trim().length();
        if (nameLength > MAX_CAR_NAME_LENGTH || nameLength < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 입력가능합니다. 입력한 자동차 이름: " + name);
        }
    }

    private void checkNull(String name) {
        if (name == null) {
            throw new NullPointerException("자동차 이름은 null 값을 입력할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
