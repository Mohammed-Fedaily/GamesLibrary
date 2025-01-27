public abstract class BoardGame {
    protected Cell[][] board;
    protected Player[] players;
    protected Player currentPlayer;
    protected final View view;

    public BoardGame(Player[] players, View view) {
        this.players = players;
        this.currentPlayer = players[0];
        this.view = view;
        initializeBoard();
    }

    protected abstract int[] getMoveCoordinates(Player player);
    protected abstract void initializeBoard();
    protected abstract boolean isWinningMove(int row, int col);
    protected abstract boolean isValidMove(int row, int col);
    protected abstract boolean isGameOver();

    protected void makeMove(int row, int col) {
        board[row][col].setRepresentation(currentPlayer.getRepresentation());
    }

    protected void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    public void play() {
        while (!isGameOver()) {
            view.displayBoard(board);
            view.displayCurrentPlayer(currentPlayer);

            int[] move = getMoveCoordinates(currentPlayer);

            if (isValidMove(move[0], move[1])) {
                makeMove(move[0], move[1]);
                if (isWinningMove(move[0], move[1])) {
                    view.displayBoard(board);
                    view.displayWinner(currentPlayer);
                    return;
                }
                switchPlayer();
            } else {
                view.displayInvalidMove();
            }
        }
        view.displayBoard(board);
        view.displayDraw();
    }
}