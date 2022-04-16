package baseball;

import baseball.controller.GameController;
import baseball.model.ComputerPlayerModel;
import baseball.model.ComputerModel;
import baseball.view.GameView;
import baseball.view.NextStepConsoleView;

public class Application {
    public static void main(String[] args) {
        ComputerModel player = new ComputerPlayerModel();
        GameView view = new NextStepConsoleView();
        GameController game = new GameController(player, view);
        game.run();
    }
}
