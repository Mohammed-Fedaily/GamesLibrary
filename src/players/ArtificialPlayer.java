package players;

import board.Cell;
import View.GameView;
import java.util.Random;


public class ArtificialPlayer extends Player {
    private final Random random;
    private final GameView view;

    public ArtificialPlayer(String symbol, GameView view) {
        super(symbol);
        this.random = new Random();
        this.view = view;
    }

    @Override
    public int[] getMove(Cell[][] board) {
        int[] move = new int[2];
        move[0] = random.nextInt(board.length);
        move[1] = random.nextInt(board[0].length);
        return move;
    }
}