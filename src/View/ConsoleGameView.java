package View;
import board.Cell;
import players.Player;

public class ConsoleGameView implements GameView {
    @Override
    public void displayBoard(Cell[][] board) {
        clearScreen();
        int boardSize = board[0].length;
        String border = "-".repeat(boardSize * 4 + 4); // Adjust border based on board size

        System.out.print("     ");
        for (int i = 1; i <= boardSize; i++) {
            System.out.printf("%-4d", i);
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            System.out.printf("%-3d ", (i + 1));
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("| %-2s", board[i][j].getRepresentation().replace("|", ""));
            }
            System.out.println("|");
        }
        System.out.println(border);
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
        displayMenu("Select game mode:", new String[]{
                "Human vs Human",
                "Human vs Computer",
                "Computer vs Computer"
        });
    }

    @Override
    public void displayGameSelectionMenu() {
        displayMenu("Select game:", new String[]{
                "TicTacToe",
                "Gomoku",
                "Connect Four"
        });
    }

    @Override
    public void getMoveInput() {
        System.out.print("Enter row and column ");
    }

    private void displayMenu(String title, String[] options) {
        System.out.println(title);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d. %s%n", i + 1, options[i]);
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}