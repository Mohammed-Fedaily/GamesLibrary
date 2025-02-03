package Controller;

import Model.TicTacToeModel;
import View.GameView;

public class TicTacToeController extends GameController {
    public TicTacToeController(TicTacToeModel model, GameView view) {
        super(model, view);
    }

    @Override
    protected void initializePlayers() {
        view.displayGameModeMenu();
    }
}

//    @Override
//    protected void initializePlayers() {
//        view.displayGameModeMenu();
//    }

