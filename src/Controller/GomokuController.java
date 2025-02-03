package Controller;

import Model.GomokuModel;
import View.GameView;

public class GomokuController extends GameController {
    public GomokuController(GomokuModel model, GameView view) {
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
