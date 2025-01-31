package Controller;

import Model.BoardGameModel;
import View.GameView;
import players.HumanPlayer;

public abstract class GameController {
    protected BoardGameModel model;
    protected GameView view;
    protected final int[] lastMove;

    public GameController(BoardGameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.lastMove = new int[2];
    }

    public void startGame() {
        while (!model.isGameOver()) {
            playTurn();
        }
        endGame();
    }

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
        if (model.makeMove(row, col)) {
            lastMove[0] = row;
            lastMove[1] = col;
            handleGameSpecificRules(row, col);
            return true;
        } else {
            if (model.getCurrentPlayer() instanceof HumanPlayer) {
                view.displayInvalidMove();
            }
            return false;
        }
    }


    protected void endGame() {
        view.displayBoard(model.getBoard());
        if (model.isWinningMove(lastMove[0], lastMove[1])) {
            view.displayWinner(model.getCurrentPlayer());
        } else {
            view.displayDraw();
        }
    }

    protected abstract void handleGameSpecificRules(int row, int col);
}