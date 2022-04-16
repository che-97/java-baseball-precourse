package baseball.controller;

import baseball.constant.Digit;
import baseball.constant.ReservedWord;
import baseball.model.ComputerModel;
import baseball.view.GameView;

import java.util.LinkedHashSet;

public class GameController {

    private ComputerModel computer;
    private GameView view;

    //랜덤 수 저장

    public GameController(ComputerModel player, GameView view){
       this.computer = player;
       this.view = view;
    }

    public void run() {
        int start = ReservedWord.RESTART.getNumber();
        while (start == ReservedWord.RESTART.getNumber()) {
            //초기화
            //컴퓨터에서 랜덤 숫자 생성 (computer model)
            LinkedHashSet<Integer> randomNumberSet = computer.getRandomNumber();
            this.compareUntilStrike(randomNumberSet);

            //재시작할지 여부 받음
            view.getGameOverMessage();
            view.getCheckRestartMessage();
            start = view.getInputReservedWord();

            //초기화
            randomNumberSet.clear();
            randomNumberSet = null;
        }
    }

    public void compareUntilStrike(LinkedHashSet<Integer> randomNumberSet){
        boolean isStrikeAll = false;
        while (!isStrikeAll){
            view.getReqInputMessage();
            LinkedHashSet<Integer> userInputSet = view.getInputNumber();

            isStrikeAll = isStrikeAll(randomNumberSet,userInputSet);

            userInputSet.clear();
            userInputSet = null;
        }
    }

    public boolean isStrikeAll(LinkedHashSet<Integer> randomNumberSet, LinkedHashSet<Integer> userInputSet){
        int[] result = computer.checkBallAndStrike(randomNumberSet,userInputSet);

        int ball = result[0];
        int strike = result[1];

        view.getBallCntAndStrikeCntMessage(ball,strike);
        if(strike == Digit.LENGTH.getNumber()){
            return true;
        }
        return false;
    }


}
