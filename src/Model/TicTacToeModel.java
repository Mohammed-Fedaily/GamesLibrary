package Model;

import board.Cell;
import players.Player;


public class TicTacToeModel extends BoardGameModel {
    private static final int SIZE = 3;
    private boolean isWinner;

    public TicTacToeModel(Player[] players) {
        super(players);
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
    public boolean makeMove(int row, int col) {
        if (isValidMove(row, col)) {
            int[] move = {row, col};
            writeMove(move, currentPlayer.getRepresentation());
            return true;
        }
        return false;
    }

    @Override
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE &&
                col >= 0 && col < SIZE &&
                board[row][col].isEmpty();
    }

    @Override
    public boolean isWinningMove(int row, int col) {
        return isWinner = checkRow(row) || checkColumn(col) || checkDiagonals();
    }

    protected boolean checkRow(int row) {
        return !board[row][0].isEmpty() &&
                board[row][0].getRepresentation().equals(board[row][1].getRepresentation()) &&
                board[row][0].getRepresentation().equals(board[row][2].getRepresentation());
    }

    protected boolean checkColumn(int col) {
        return !board[0][col].isEmpty() &&
                board[0][col].getRepresentation().equals(board[1][col].getRepresentation()) &&
                board[0][col].getRepresentation().equals(board[2][col].getRepresentation());
    }

    protected boolean checkDiagonals() {
        boolean mainDiagonal = !board[0][0].isEmpty() &&
                board[0][0].getRepresentation().equals(board[1][1].getRepresentation()) &&
                board[0][0].getRepresentation().equals(board[2][2].getRepresentation());

        boolean antiDiagonal = !board[0][2].isEmpty() &&
                board[0][2].getRepresentation().equals(board[1][1].getRepresentation()) &&
                board[0][2].getRepresentation().equals(board[2][0].getRepresentation());

        return mainDiagonal || antiDiagonal;
    }

    @Override
    public boolean isGameOver() {
        if (isWinner) {
            return true;
        }

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