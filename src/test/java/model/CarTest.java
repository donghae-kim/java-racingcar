package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @ParameterizedTest(name = "Car 객체 생성 테스트 name = {0}")
    @ValueSource(strings = {"pobi", "crong", "honux", "hi hi", "jj503"})
    void createCarTest(String name) {
        Car car = new Car(name);
        assertThat(car.getCarName()).isEqualTo(name);
    }

    @ParameterizedTest(name = "Car 객체 생성 예외 테스트 name = {0}")
    @ValueSource(strings = {"pobiiii", "", "  "})
    void createExceptionCarTest(String name) {
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest(name = "랜덤 값이 4미만일 경우 테스트 randNum = {0}")
    @ValueSource(ints = {0, 1, 2, 3})
    void stopByRandom(int randNum) {
        Car car = new Car("test");
        car.moveByRandom(randNum);

        assertThat(car.getCarLocation()).isEqualTo(0);
    }

    @ParameterizedTest(name = "랜덤 값이 4이상 일 경우 테스트 randNum = {0}")
    @ValueSource(ints = {4, 5, 6, 7})
    void moveByRandom(int randNum) {
        Car car = new Car("test");
        car.moveByRandom(randNum);

        assertThat(car.getCarLocation()).isEqualTo(1);
    }
}