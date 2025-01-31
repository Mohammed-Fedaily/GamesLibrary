package Controller;

import Model.BoardGameModel;
import View.GameView;

public class GomokuController extends GameController {

    public GomokuController(BoardGameModel model, GameView view) {
        super(model, view);
    }

    @Override
    protected void handleGameSpecificRules(int row, int col) {
        if (!model.isWinningMove(row, col)) {
            model.switchPlayer();
        }
    }

//    @Override
//    protected void initializePlayers() {
//        view.displayGameModeMenu();
//    }
}