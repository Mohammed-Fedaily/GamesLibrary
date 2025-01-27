package players;
import board.Cell;
import ui.InteractionUtilisateur;
import ui.View;

public class HumanPlayer extends Player {
    private final InteractionUtilisateur interaction;
    private final View view;

    public HumanPlayer(String symbol, InteractionUtilisateur interaction, View view) {
        super(symbol);
        this.interaction = interaction;
        this.view = view;
    }

    @Override
    public int[] getMove(Cell[][] board) {
        int[] coordinates;
        boolean validMove = false;

        while (!validMove) {
            view.displayMovePrompt(this);
            coordinates = interaction.getPlayerMove();

            if (isValidMove(coordinates[0], coordinates[1], board)) {
                return coordinates;
            }
            view.displayInvalidMove();
        }
        return null;
    }

    @Override
    public int getColumnMove(Cell[][] board) {
        view.displayColumnPrompt(this);
        return interaction.getColumnChoice();
    }

    private boolean isValidMove(int row, int col, Cell[][] board) {
        return row >= 0 && row < board.length &&
                col >= 0 && col < board[0].length &&
                board[row][col].isEmpty();
    }
}