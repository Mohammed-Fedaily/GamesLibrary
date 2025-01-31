package players;

import board.Cell;


public abstract class Player {
    protected String representation;

    public Player(String symbol) {
        this.representation = "| " + symbol + " ";
    }

    public String getRepresentation() {
        return representation;
    }

    public abstract int[] getMove(Cell[][] board);
}
