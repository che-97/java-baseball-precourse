package baseball.model;

import baseball.constant.Digit;

import java.util.LinkedHashSet;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ComputerPlayerModel implements ComputerModel {

    @Override
    public LinkedHashSet<Integer> getRandomNumber() {

        LinkedHashSet<Integer> randomNumberSet = new LinkedHashSet<>();

        while (randomNumberSet.size() != Digit.LENGTH.getNumber()) {
            int randomNum = pickNumberInRange(Digit.START_RANGE.getNumber()
                , Digit.END_RANGE.getNumber());
            randomNumberSet.add(randomNum);
        }

        return randomNumberSet;
    }

    @Override
    public int[] checkBallAndStrike(LinkedHashSet<Integer> randomNumberSet,
        LinkedHashSet<Integer> userInputSet) {
        int strike = getStrikeNumber(randomNumberSet, userInputSet);
        int ball = getBallNumber(randomNumberSet, userInputSet);
        ball = ball - strike;
        return new int[]{ball, strike};
    }

    public int getStrikeNumber(LinkedHashSet<Integer> randomNumberSet,
        LinkedHashSet<Integer> userInputSet) {
        int strike = 0;

        int randomNumOrder = 0;
        for (int randomNumber : randomNumberSet) {
            strike = matchUserInputSet(randomNumber, userInputSet, randomNumOrder, strike);
            randomNumOrder++;
        }

        return strike;
    }

    public int matchUserInputSet(int randomNumber, LinkedHashSet<Integer> userInputSet,
        int randomNumOrder, int strike) {
        int userInputOrder = 0;
        for (int userInput : userInputSet) {
            strike = isStrike(randomNumOrder, userInputOrder, randomNumber, userInput, strike);
            userInputOrder++;
        }
        return strike;
    }

    public int isStrike(int randomNumOrder, int userInputOrder, int randomNumber, int userInput,
        int strike) {
        if (randomNumOrder == userInputOrder && userInput == randomNumber) {
            strike++;
        }
        return strike;
    }

    public int getBallNumber(LinkedHashSet<Integer> randomNumberSet,
        LinkedHashSet<Integer> userInputSet) {
        userInputSet.retainAll(randomNumberSet);
        return userInputSet.size();
    }

}
