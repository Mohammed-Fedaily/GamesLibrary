package Controller;

import Model.BoardGameModel;
import View.GameView;
import players.HumanPlayer;

public class GomokuController extends GameController{

    private final int[] lastMove;
    public GomokuController(BoardGameModel model, GameView view) {

        super(model, view);
        this.lastMove = new int[2];
    }

    @Override
    public void startGame() {
        while (!model.isGameOver()) {
            playTurn();
        }
        endGame();
    }

    @Override
    protected void playTurn() {
        view.displayBoard(model.getBoard());
        view.displayCurrentPlayer(model.getCurrentPlayer());
        int[] move;
        boolean validMove = false;
        do {
            move = model.getCurrentPlayer().getMove(model.getBoard());
            validMove = handleMove(move[0], move[1]);
        } while (!validMove);
    }

    protected boolean handleMove(int row, int col) {
        if (model.isValidMove(row, col)) {
            int[] move = {row, col};
            model.writeMove(move, model.getCurrentPlayer().getRepresentation());
            lastMove[0] = row;
            lastMove[1] = col;
            handleGomokuSpecificRules(row, col);
            return true;
        } else {
            if (model.getCurrentPlayer() instanceof HumanPlayer) {
                view.displayInvalidMove();
            }
            return false;
        }
    }

    @Override
    protected void endGame() {
        view.displayBoard(model.getBoard());
        if (model.isWinningMove(lastMove[0], lastMove[1])) {
            view.displayWinner(model.getCurrentPlayer());
        } else {
            view.displayDraw();
        }
    }

    @Override
    protected void initializePlayers() {
        view.displayGameModeMenu();
    }

    private void handleGomokuSpecificRules(int row, int col) {
        if (!model.isWinningMove(row, col)) {
            model.switchPlayer();
        }
    }

}
