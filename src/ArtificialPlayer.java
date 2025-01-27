import java.util.Random;

public class ArtificialPlayer extends Player {
    private final Random random;
    private final View view;

    public ArtificialPlayer(String symbol, View view) {
        super(symbol);
        this.random = new Random();
        this.view = view;
    }

    @Override
    public int[] getMove(Cell[][] board) {
        int[] coordinates = new int[2];
        boolean validMove = false;

        while (!validMove) {
            coordinates[0] = random.nextInt(board.length);
            coordinates[1] = random.nextInt(board.length);

            if (board[coordinates[0]][coordinates[1]].isEmpty()) {
                validMove = true;
            }
        }

        view.displayComMove(coordinates[0], coordinates[1]);
        return coordinates;
    }

    @Override
    public int getColumnMove(Cell[][] board) {
        int col;
        do {
            col = random.nextInt(board[0].length);
        } while (!board[0][col].isEmpty());
        view.displayComColumnMove(col);
        return col;
    }

}