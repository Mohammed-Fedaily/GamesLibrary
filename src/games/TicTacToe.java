package games;
import board.BoardGame;
import board.Cell;
import players.Player;
import ui.View;

public class TicTacToe extends BoardGame {
    private static final int SIZE = 3;
    private boolean isWinner;

    public TicTacToe(Player[] players, View view) {
        super(players, view);
        this.isWinner = false;
    }

    @Override
    protected int[] getMoveCoordinates(Player player) {
        return player.getMove(board);
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
    protected boolean isWinningMove(int row, int col) {
        isWinner = checkRow(row) || checkColumn(col) || checkDiagonals() ;
        return isWinner;
    }

    private boolean checkRow(int row) {
        return !board[row][0].isEmpty() &&
                board[row][0].getRepresentation().equals(board[row][1].getRepresentation()) &&
                board[row][0].getRepresentation().equals(board[row][2].getRepresentation());
    }

    private boolean checkColumn(int col) {
        return !board[0][col].isEmpty() &&
                board[0][col].getRepresentation().equals(board[1][col].getRepresentation()) &&
                board[0][col].getRepresentation().equals(board[2][col].getRepresentation());
    }


    private boolean checkDiagonals() {
        boolean mainDiagonal = !board[0][0].isEmpty() &&
                board[0][0].getRepresentation().equals(board[1][1].getRepresentation()) &&
                board[0][0].getRepresentation().equals(board[2][2].getRepresentation());

        boolean antiDiagonal = !board[0][2].isEmpty() &&
                board[0][2].getRepresentation().equals(board[1][1].getRepresentation()) &&
                board[0][2].getRepresentation().equals(board[2][0].getRepresentation());

        return mainDiagonal || antiDiagonal;
    }

    @Override
    protected boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE &&
                col >= 0 && col < SIZE &&
                board[row][col].isEmpty();
    }

    @Override
    protected boolean isGameOver() {
        return isWinner || isBoardFull();
    }

    private boolean isBoardFull() {
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