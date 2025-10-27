package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );

    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차의 이름이 ,를 포함하지 않고 적절하게 입력되지 않았을 경우 예외 처리 테스트")
    void InvalidCarNameExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi.javaji", "1"))
                        .isInstanceOf(InValidCarNameException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a", "1"))
                        .isInstanceOf(InValidCarNameException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(InValidCarNameException.class)
        );
    }

    @Test
    @DisplayName("자동차의 이름이 2개 미만으로 입력되었을 경우 예외 처리 테스트")
    void InsufficientCarCountException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,", "1"))
                        .isInstanceOf(InsufficientCarCountException.class)
        );
    }

    @Test
    @DisplayName("입력받은 자동차의 이름 중 공백이 있을 경우 예외 처리 테스트")
    void InputCarNameException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a, ,c", "1"))
                        .isInstanceOf(InputCarNameException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
