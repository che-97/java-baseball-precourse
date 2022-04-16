package baseball.view;

import baseball.constant.ErrorMessage;
import baseball.constant.Hint;
import baseball.constant.BaseBall;
import baseball.constant.Digit;
import baseball.constant.ReservedWord;

import java.util.LinkedHashSet;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class NextStepConsoleView implements GameView{

    private static final String NUMBER_FORMAT = "[0-9]+";
    private static final String DIGIT_RANGE_FORMAT = "[1-9][1-9][1-9]";

    @Override
    public void getReqInputMessage() {
        System.out.print(Hint.HINT_ASK_INPUT.getMessage());
    }

    @Override
    public void getGameOverMessage() {
        System.out.println(Hint.HINT_GAME_OVER.getMessage());
    }

    @Override
    public void getCheckRestartMessage() {
        System.out.println(Hint.HINT_RESTART.getMessage());
    }

    @Override
    public void getBallCntAndStrikeCntMessage(int ball, int strike) {
        String message = "";
        if(ball != 0){
            message += ball+ BaseBall.BALL.getString()+" ";
        }
        if(strike != 0){
            message += strike+ BaseBall.STRIKE.getString();
        }
        if(message.isEmpty()){
            message = BaseBall.NOTHING.getString();
        }
        System.out.println(message);
    }

    @Override
    public LinkedHashSet<Integer> getInputNumber() {
        String userInput = readLine();
        this.validateConvertNumber(userInput);
        this.validateDigitsInRange(userInput);
        LinkedHashSet<Integer> userInputSet = this.userInputStringToSet(userInput);
        this.validateDuplicate(userInput.length(),userInputSet.size());
        return userInputSet;
    }

    public void validateConvertNumber(String userInput){
        if(!userInput.matches(NUMBER_FORMAT)){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public void validateDigitsInRange(String userInput){
        if(!userInput.matches(DIGIT_RANGE_FORMAT)){
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
        }
    }

    public LinkedHashSet<Integer> userInputStringToSet(String userInput){
        LinkedHashSet<Integer> userInputSet = new LinkedHashSet<>();
        for (int i = 0; i<Digit.LENGTH.getNumber(); i++){
            userInputSet.add(Character.getNumericValue(userInput.charAt(i)));
        }
        return userInputSet;
    }

    public void validateDuplicate(int userInputLength, int userInputSetSize){
        if(userInputLength != userInputSetSize){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_EXISTS.getMessage());
        }
    }

    @Override
    public int getInputReservedWord() {
        String userInput = readLine();
        //예약어인지 확인
        this.validateReservedWord(userInput);
        return Integer.parseInt(userInput);
    }

    public void validateReservedWord(String userInput){
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
