package View;
import board.Cell;
import players.Player;

public class ConsoleGameView implements GameView {
    private static final String BORDER = "-".repeat(31);

    @Override
    public void displayBoard(Cell[][] board) {
        clearScreen();

        System.out.print("     ");
        for (int i = 1; i <= board[0].length; i++) {
            System.out.printf("%-5d", i);
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            System.out.printf("%-2d", (i + 1));

            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("| %-2s", board[i][j].getRepresentation().replace("|", ""));
            }
            System.out.println("|");
        }
        System.out.println(BORDER);
    }

    @Override
    public void displayCurrentPlayer(Player player) {
        System.out.println("Current player: " + player.getRepresentation().replace("|",""));
    }

    @Override
    public void displayWinner(Player player) {
        System.out.println("Player " + player.getRepresentation().replace("|","") + " wins!");
    }

    @Override
    public void displayDraw() {
        System.out.println("Game ended in a draw!");
    }

    @Override
    public void displayInvalidMove() {
        System.out.println("Invalid move! Try again.");
    }

    @Override
    public void displayGameModeMenu() {
        System.out.println("Select game mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("3. Computer vs Computer");
    }

    @Override
    public void displayGameSelectionMenu() {
        System.out.println("Select game:");
        System.out.println("1. TicTacToe");
        System.out.println("2. Gomoku");
        System.out.println("3. Connect Four");
    }

    @Override
    public void getMoveInput() {
        System.out.print("Enter row and column ");
    }

    private void printColumnNumbers(int columns) {
        System.out.print("  ");
        for (int i = 1; i <= columns; i++) {
            System.out.print("   " + i);
        }
        System.out.println();
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
