package players;
import board.Cell;
import ui.View;
import View.GameView;

import java.util.Scanner;


public class HumanPlayer extends Player {
    private final GameView view;
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String symbol, GameView view) {
        super(symbol);
        this.view = view;
    }

    @Override
    public int[] getMove(Cell[][] board) {
        view.getMoveInput();
        int[] move = new int[2];
        move[0] = scanner.nextInt() - 1;
        move[1] = scanner.nextInt() - 1;
        return move;
    }
}
