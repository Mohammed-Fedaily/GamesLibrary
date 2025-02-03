package Controller;

import Model.BoardGameModel;
import View.GameView;
import players.HumanPlayer;

public abstract class GameController {
    protected BoardGameModel model;
    protected GameView view;
    protected final int[] lastMove;
    protected boolean isWinner;

    public GameController(BoardGameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.lastMove = new int[2];
    }

    public void startGame() {
        while (!isGameOver()) {
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
        if (isValidMove(row, col)) {
            int[] move = {row, col};
            model.writeMove(move, model.getCurrentPlayer().getRepresentation());
            lastMove[0] = row;
            lastMove[1] = col;
            if (!isWinningMove(row, col)) {
                model.switchPlayer();
            } else {
                isWinner = true;
            }
            return true;
        } else {
            if (model.getCurrentPlayer() instanceof HumanPlayer) {
                view.displayInvalidMove();
            }
            return false;
        }
    }

    protected boolean isValidMove(int row, int col) {
        return row >= 0 && row < model.getTableSize() &&
                col >= 0 && col < model.getTableSize() &&
                model.isCellEmpty(row, col);
    }

    protected boolean isGameOver() {
        if (isWinner) {
            return true;
        }

        for (int i = 0; i < model.getTableSize(); i++) {
            for (int j = 0; j < model.getTableSize(); j++) {
                if (model.isCellEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean isWinningMove(int row, int col) {
        String symbol = model.getCurrentPlayer().getRepresentation();
        return checkRow(row, symbol) ||
                checkColumn(col, symbol) ||
                checkDiagonals(row, col, symbol);
    }

    protected boolean checkRow(int row, String symbol) {
        int count = 0;
        for (int j = 0; j < model.getTableSize(); j++) {
            if (model.getCellRepresentation(row, j).equals(symbol)) {
                count++;
                if (count == model.getWinCount()) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    protected boolean checkColumn(int col, String symbol) {
        int count = 0;
        for (int i = 0; i < model.getTableSize(); i++) {
            if (model.getCellRepresentation(i, col).equals(symbol)) {
                count++;
                if (count == model.getWinCount()) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    protected boolean checkDiagonals(int row, int col, String symbol) {
        return checkMainDiagonal(row, col, symbol) ||
                checkAntiDiagonal(row, col, symbol);
    }

    protected boolean checkMainDiagonal(int row, int col, String symbol) {
        int count = 0;
        for (int i = 0; i < model.getTableSize(); i++) {
            if (row - i >= 0 && col - i >= 0) {
                if (model.getCellRepresentation(row-i, col-i).equals(symbol)) {
                    count++;
                    if (count == model.getWinCount()) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    protected boolean checkAntiDiagonal(int row, int col, String symbol) {
        int count = 0;
        for (int i = 0; i < model.getTableSize(); i++) {
            if (row - i >= 0 && col + i < model.getTableSize()) {
                if (model.getCellRepresentation(row-i, col+i).equals(symbol)) {
                    count++;
                    if (count == model.getWinCount()) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    protected void endGame() {
        view.displayBoard(model.getBoard());
        if (isWinner) {
            view.displayWinner(model.getCurrentPlayer());
        } else {
            view.displayDraw();
        }
    }

    protected abstract void initializePlayers();
}