package games;
import board.BoardGame;
import board.Cell;
import players.Player;
import ui.View;

public class Gomoku extends BoardGame {
    private static final int SIZE = 15;
    private static final int WIN_COUNT = 5;
    private boolean isWinner;

    public Gomoku(Player[] players, View view) {
        super(players, view);
    }

    @Override
    protected void initializeBoard() {
        board = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    @Override
    protected int[] getMoveCoordinates(Player player) {
        return player.getMove(board);
    }

    @Override
    protected boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE &&
                col >= 0 && col < SIZE &&
                board[row][col].isEmpty();
    }

    @Override
    protected boolean isWinningMove(int row, int col) {
        isWinner = checkRow(row) || checkColumn(col) ||
                checkDiagonals(row, col);
        return isWinner;
    }

    private boolean checkRow(int row) {
        int count = 0;
        String symbol = currentPlayer.getRepresentation();

        for (int j = 0; j < SIZE; j++) {
            if (board[row][j].getRepresentation().equals(symbol)) {
                count++;
                if (count == WIN_COUNT) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkColumn(int col) {
        int count = 0;
        String symbol = currentPlayer.getRepresentation();

        for (int i = 0; i < SIZE; i++) {
            if (board[i][col].getRepresentation().equals(symbol)) {
                count++;
                if (count == WIN_COUNT) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkDiagonals(int row, int col) {
        return checkMainDiagonal(row, col) || checkAntiDiagonal(row, col);
    }

    private boolean checkMainDiagonal(int row, int col) {
        int count = 0;
        String symbol = currentPlayer.getRepresentation();

        for (int i = 0; i < SIZE; i++) {
            if (row - i >= 0 && col - i >= 0) {
                if (board[row-i][col-i].getRepresentation().equals(symbol)) {
                    count++;
                    if (count == WIN_COUNT) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkAntiDiagonal(int row, int col) {
        int count = 0;
        String symbol = currentPlayer.getRepresentation();

        for (int i = 0; i < SIZE; i++) {
            if (row - i >= 0 && col + i < SIZE) {
                if (board[row-i][col+i].getRepresentation().equals(symbol)) {
                    count++;
                    if (count == WIN_COUNT) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean isGameOver() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}