package baseball;

import baseball.controller.GameController;
import baseball.model.ComputerPlayer;
import baseball.model.ComputerModel;
import baseball.view.GameView;
import baseball.view.NextStepConsoleView;

public class Application {
    public static void main(String[] args) {
        ComputerModel player = new ComputerPlayer();
        GameView view = new NextStepConsoleView();
        GameController game = new GameController(player, view);
        game.run();
    }
}
