package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class ComputerPlayerModelTest {
    private final ComputerPlayerModel model = new ComputerPlayerModel();

    @DisplayName("[model] 램덤 수 생성")
    @Test
    void whenCallRandomNumberMethod_thenReturnsRandomSet() throws Exception {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThat(model.getRandomNumber())
                            .isNotEmpty()
                            .hasSize(3)
                            .startsWith(1,3,5);
                },
                1, 3,3,5
        );
    }

    @DisplayName("[model] ball과 strike 갯수 체크, 1 ball 1 strike")
    @Test
    void givenTwoSet_whenCheckBallAndStrike_thenReturnsBallAndStrike() throws Exception {
        //Given
        LinkedHashSet<Integer> randomNumberSet = new LinkedHashSet<>();
        randomNumberSet.add(1);
        randomNumberSet.add(3);
        randomNumberSet.add(5);

        LinkedHashSet<Integer> userInputSet = new LinkedHashSet<>();
        userInputSet.add(1);
        userInputSet.add(5);
        userInputSet.add(8);

        // When & then
        assertThat(model.checkBallAndStrike(randomNumberSet,userInputSet))
                .isNotEmpty()
                .hasSize(2)
                .startsWith(1,1);
    }

}