package Model;
import board.Cell;
import players.Player;

public abstract class BoardGameModel {
    protected Cell[][] board;
    protected Player[] players;
    protected Player currentPlayer;

    public BoardGameModel(Player[] players) {
        this.players = players;
        this.currentPlayer = players[0];
        initializeBoard();
    }

    protected abstract void initializeBoard();

    public abstract boolean makeMove(int row, int col);
    public abstract boolean isValidMove(int row, int col);
    public abstract boolean isWinningMove(int row, int col);
    public abstract boolean isGameOver();

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

}
