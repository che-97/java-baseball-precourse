package baseball.view;

import java.util.LinkedHashSet;

public interface GameView {

    //화면에 숫자 입력 요청 메시지 출력
    void getReqInputMessage();

    //화면에 게임종료 메시지 출력
    void getGameOverMessage();

    //화면에 재시작 여부 확인하는 메시지 출력
    void getCheckRestartMessage();

    //화면에 Ball수와 Strike수 출력
    void getBallCntAndStrikeCntMessage(int ball, int strike);

    //사용자에게 숫자 받아옴
    LinkedHashSet<Integer> getInputNumber();

    //사용자에게 예약어 받아옴
    int getInputReservedWord();

}

