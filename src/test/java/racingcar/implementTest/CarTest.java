package racingcar.implementTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;

public class CarTest {
    private Car testCar;

    @BeforeEach
    void setUpCar(){
        testCar = new Car("Test");
    }

    @Test
    void 자동차_이름_입력_저장(){
        Car pobiCar = new Car("pobi");
        Assertions.assertThat(pobiCar.getCarName()).isEqualTo("pobi");
        Car woniCar = new Car("woni");
        Assertions.assertThat(woniCar.getCarName()).isEqualTo("woni");
    }

    @Test
    void 자동차_전진(){
        //초기값은 0
        Assertions.assertThat(testCar.getPosition()).isEqualTo(0);

        testCar.moveForward();
        Assertions.assertThat(testCar.getPosition()).isEqualTo(1);

        testCar.moveForward();
        Assertions.assertThat(testCar.getPosition()).isEqualTo(2);
    }
}