// BoardGameModel.java
package Model;

import board.Cell;
import players.Player;

public abstract class BoardGameModel {
    protected Cell[][] board;
    protected Player[] players;
    protected Player currentPlayer;
    protected final int size;
    protected final int winCount;
    protected boolean isWinner;

    public BoardGameModel(Player[] players, int size, int winCount) {
        this.players = players;
        this.currentPlayer = players[0];
        this.size = size;
        this.winCount = winCount;
        initializeBoard();
    }

    protected void initializeBoard() {
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public boolean makeMove(int row, int col) {
        if (isValidMove(row, col)) {
            int[] move = {row, col};
            writeMove(move, currentPlayer.getRepresentation());
            return true;
        }
        return false;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size &&
                col >= 0 && col < size &&
                board[row][col].isEmpty();
    }

    public abstract boolean isWinningMove(int row, int col);

    public boolean isGameOver() {
        if (isWinner) {
            return true;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    public Cell[][] getBoard() {
        return board;
    }


    public void writeMove(int[] move, String representation) {
        board[move[0]][move[1]].setRepresentation(representation);
    }

    protected boolean checkRow(int row, String symbol) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            if (board[row][j].getRepresentation().equals(symbol)) {
                count++;
                if (count == winCount) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    protected boolean checkColumn(int col, String symbol) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][col].getRepresentation().equals(symbol)) {
                count++;
                if (count == winCount) return true;
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
        for (int i = 0; i < size; i++) {
            if (row - i >= 0 && col - i >= 0) {
                if (board[row-i][col-i].getRepresentation().equals(symbol)) {
                    count++;
                    if (count == winCount) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    protected boolean checkAntiDiagonal(int row, int col, String symbol) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (row - i >= 0 && col + i < size) {
                if (board[row-i][col+i].getRepresentation().equals(symbol)) {
                    count++;
                    if (count == winCount) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }
}