package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.util.ValidationUtil.validateConvertNumber;
import static baseball.util.ValidationUtil.validateDigitsInRange;
import static baseball.util.ValidationUtil.validateDuplicate;
import static baseball.util.ValidationUtil.validateReservedWord;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ValidationUtilTest {

    @DisplayName("숫자가 아니면 IllegalArgumentException 발생")
    @Test
    void givenUserInputString_whenCallValidateConvertNumberMethod_thenIllegalArgumentException()
        throws Exception {
        //Given
        String userInput = "숫자아님";
        // When & then
        assertThatThrownBy(() -> validateConvertNumber(userInput))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 지정된 범위를 벗어나면 IllegalArgumentException 발생")
    @Test
    void givenUserInputString_whenCallValidateDigitsInRangeMethod_thenIllegalArgumentException()
        throws Exception {
        //Given
        String userInput = "1234";
        // When & then
        assertThatThrownBy(() -> validateDigitsInRange(userInput))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있으면 IllegalArgumentException 발생")
    @Test
    void givenTwoUserInputLength_whenCallValidateDuplicateMethod_thenIllegalArgumentException()
        throws Exception {
        //Given
        int userInputStringLength = 3;
        int deduplicatedUserInputLength = 2;
        // When & then
        assertThatThrownBy(
            () -> validateDuplicate(userInputStringLength, deduplicatedUserInputLength))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지정된 예약어가 아니면 IllegalArgumentException 발생")
    @Test
    void givenUserInputString_whenCallValidateReservedWordMethod_thenIllegalArgumentException()
        throws Exception {
        //Given
        String userInput = "3";
        // When & then
        assertThatThrownBy(() -> validateReservedWord(userInput))
            .isInstanceOf(IllegalArgumentException.class);
    }
}