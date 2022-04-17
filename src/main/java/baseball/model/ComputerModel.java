package baseball.model;

import java.util.LinkedHashSet;

public interface ComputerModel {

    //램덤 수 생성
    LinkedHashSet<Integer> getRandomNumber();

    //ball과 strike 갯수 체크, return {ballNCnt, strikeCnt}
    int[] checkBallAndStrike(LinkedHashSet<Integer> randomNumberSet,
        LinkedHashSet<Integer> userInputSet);

}
