package baseball.view;

import baseball.constant.Hint;
import baseball.constant.BaseBall;
import baseball.constant.Digit;

import java.util.LinkedHashSet;

import static baseball.util.ValidationUtil.validateConvertNumber;
import static baseball.util.ValidationUtil.validateDigitsInRange;
import static baseball.util.ValidationUtil.validateDuplicate;
import static baseball.util.ValidationUtil.validateReservedWord;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class NextStepConsoleView implements GameView {

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
        if (ball != 0) {
            message += ball + BaseBall.BALL.getString() + " ";
        }
        if (strike != 0) {
            message += strike + BaseBall.STRIKE.getString();
        }
        if (message.isEmpty()) {
            message = BaseBall.NOTHING.getString();
        }
        System.out.println(message);
    }

    @Override
    public LinkedHashSet<Integer> getInputNumber() {
        String userInput = readLine();
        validateConvertNumber(userInput);
        validateDigitsInRange(userInput);
        LinkedHashSet<Integer> userInputSet = this.userInputStringToSet(userInput);
        validateDuplicate(userInput.length(), userInputSet.size());
        return userInputSet;
    }

    public LinkedHashSet<Integer> userInputStringToSet(String userInput) {
        LinkedHashSet<Integer> userInputSet = new LinkedHashSet<>();
        for (int i = 0; i < Digit.LENGTH.getNumber(); i++) {
            userInputSet.add(Character.getNumericValue(userInput.charAt(i)));
        }
        return userInputSet;
    }

    @Override
    public int getInputReservedWord() {
        String userInput = readLine();
        //예약어인지 확인
        validateReservedWord(userInput);
        return Integer.parseInt(userInput);
    }

}
