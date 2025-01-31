package Controller;
import View.GameView;
import Model.BoardGameModel;


public abstract class GameController {
    protected GameView view;
    protected BoardGameModel model;

    public GameController(BoardGameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public abstract void startGame();
    protected abstract void playTurn();
    protected abstract boolean handleMove(int row, int col);
    protected abstract void endGame();
    protected abstract void initializePlayers();
}
