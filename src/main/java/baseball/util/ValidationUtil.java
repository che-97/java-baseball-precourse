package baseball.util;

import baseball.constant.ErrorMessage;
import baseball.constant.ReservedWord;

public class ValidationUtil {
    private static final String NUMBER_FORMAT = "[0-9]+";
    private static final String DIGIT_RANGE_FORMAT = "[1-9][1-9][1-9]";

    public static void validateConvertNumber(String userInput){
        if(!userInput.matches(NUMBER_FORMAT)){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public static void validateDigitsInRange(String userInput){
        if(!userInput.matches(DIGIT_RANGE_FORMAT)){
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
        }
    }

    public static void validateDuplicate(int userInputLength, int userInputSetSize){
        if(userInputLength != userInputSetSize){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_EXISTS.getMessage());
        }
    }

    public static void validateReservedWord(String userInput){
        if(!userInput.matches(NUMBER_FORMAT)){
            throw new IllegalArgumentException(ErrorMessage.WRONG_RESERVED_WORD.getMessage());
        }
        int reservedWord = Integer.parseInt(userInput);
        if(ReservedWord.RESTART.getNumber() != reservedWord
                && ReservedWord.STOP.getNumber() != reservedWord){
            throw new IllegalArgumentException(ErrorMessage.WRONG_RESERVED_WORD.getMessage());
        }
    }
}
