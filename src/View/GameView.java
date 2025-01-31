package View;


import board.Cell;
import players.Player;

public interface GameView {
    void displayBoard(Cell[][] board);
    void displayCurrentPlayer(Player player);
    void displayWinner(Player player);
    void displayDraw();
    void displayInvalidMove();
    void displayGameModeMenu();
    void displayGameSelectionMenu();
    void getMoveInput();
}
