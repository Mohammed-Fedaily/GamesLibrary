package Model;

import board.Cell;
import players.Player;


public class TicTacToeModel extends BoardGameModel {
    private static final int SIZE = 3;
    private static final int WIN_COUNT = 3;

    public TicTacToeModel(Player[] players) {
        super(players, SIZE, WIN_COUNT);
    }

    @Override
    public boolean isWinningMove(int row, int col) {
        String symbol = currentPlayer.getRepresentation();
        return isWinner = checkRow(row, symbol) ||
                checkColumn(col, symbol) ||
                checkDiagonals(row, col, symbol);
    }
}