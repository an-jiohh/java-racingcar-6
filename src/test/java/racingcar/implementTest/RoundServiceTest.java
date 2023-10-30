package racingcar.implementTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import racingcar.RandomNumberImpl;
import racingcar.RoundService;

public class RoundServiceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_이동_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RoundService roundService = new RoundService((start, end) -> MOVING_FORWARD);

        Method method = RoundService.class.getDeclaredMethod("randomMoveSelect");
        method.setAccessible(true);

        boolean check = (boolean) method.invoke(roundService);
        assertThat(check).isEqualTo(true);
    }

    @Test
    void 자동차_멈춤_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RoundService roundService = new RoundService((start, end) -> STOP);

        Method method = RoundService.class.getDeclaredMethod("randomMoveSelect");
        method.setAccessible(true);

        boolean check = (boolean) method.invoke(roundService);
        assertThat(check).isEqualTo(false);
    }


    @Test
    void 자동차_이동_우테코테스트() throws NoSuchMethodException {
        RoundService roundService = new RoundService(new RandomNumberImpl());

        Method method = RoundService.class.getDeclaredMethod("randomMoveSelect");
        method.setAccessible(true);

        assertRandomNumberInRangeTest(
                () -> {
                    boolean check = (boolean) method.invoke(roundService);
                    assertThat(check).isEqualTo(true);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 자동차_멈춤_우테코테스트() throws NoSuchMethodException {
        RoundService roundService = new RoundService(new RandomNumberImpl());

        Method method = RoundService.class.getDeclaredMethod("randomMoveSelect");
        method.setAccessible(true);

        assertRandomNumberInRangeTest(
                () -> {
                    boolean check = (boolean) method.invoke(roundService);
                    assertThat(check).isEqualTo(false);
                },
                STOP
        );
    }
}
