package Model;

import board.Cell;
import players.Player;

public abstract class BoardGameModel {
    protected Cell[][] board;
    protected Player[] players;
    protected Player currentPlayer;
    protected final int tableSize;
    protected final int winCount;

    public BoardGameModel(Player[] players, int size, int winCount) {
        this.players = players;
        this.currentPlayer = players[0];
        this.tableSize = size;
        this.winCount = winCount;
        initializeBoard();
    }

    protected void initializeBoard() {
        board = new Cell[tableSize][tableSize];
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    public void writeMove(int[] move, String representation) {
        board[move[0]][move[1]].setRepresentation(representation);
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col].isEmpty();
    }

    public String getCellRepresentation(int row, int col) {
        return board[row][col].getRepresentation();
    }

    public int getTableSize() {
        return tableSize;
    }

    public int getWinCount() {
        return winCount;
    }
}