package racingcar.implementTest;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Input;

public class InputTest {
    private Input input;
    @BeforeEach
    void setUpCar(){
        input = new Input();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }
    @Test
    void 입력값_테스트(){
        System.setIn(createInputStream("pobi"));
        Assertions.assertThat(input.getreadLine()).isEqualTo("pobi");

        Console.close();
        System.setIn(createInputStream("tedi"));
        Assertions.assertThat(input.getreadLine()).isEqualTo("tedi");
    }

    private InputStream createInputStream(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

}