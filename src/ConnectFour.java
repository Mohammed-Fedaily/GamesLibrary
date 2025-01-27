public class ConnectFour extends BoardGame {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final int WIN_COUNT = 4;
    private boolean hasWinner;

    public ConnectFour(Player[] players, View view) {
        super(players, view);
        this.hasWinner = false;
    }

    @Override
    protected int[] getMoveCoordinates(Player player) {
        int col = player.getColumnMove(board);
        int row = findLowestEmptyRow(col);
        return new int[]{row, col};
    }

    @Override
    protected void initializeBoard() {
        board = new Cell[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    @Override
    protected boolean isValidMove(int row, int col) {
        return col >= 0 && col < COLS && findLowestEmptyRow(col) != -1;
    }

    @Override
    protected void makeMove(int row, int col) {
        int actualRow = findLowestEmptyRow(col);
        if (actualRow != -1) {
            board[actualRow][col].setRepresentation(currentPlayer.getRepresentation());
        }
    }

    @Override
    protected boolean isWinningMove(int row, int col) {
        int actualRow = findLowestEmptyRow(col);
        if (actualRow == -1) return false;

        hasWinner = checkRow(actualRow) ||
                checkCol(col) ||
                checkDiagonals(actualRow, col);
        return hasWinner;
    }

    private int findLowestEmptyRow(int col) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col].isEmpty()) {
                return row;
            }
        }
        return -1;
    }

    private boolean checkRow(int row) {
        int count = 0;
        String symbol = currentPlayer.getRepresentation();

        for (int col = 0; col < COLS; col++) {
            if (board[row][col].getRepresentation().equals(symbol)) {
                count++;
                if (count == WIN_COUNT) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkCol(int col) {
        int count = 0;
        String symbol = currentPlayer.getRepresentation();

        for (int row = 0; row < ROWS; row++) {
            if (board[row][col].getRepresentation().equals(symbol)) {
                count++;
                if (count == WIN_COUNT) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkDiagonals(int row, int col) {
        return checkMainDiagonal(row, col) || checkAntiDiagonal(row, col);
    }

    private boolean checkMainDiagonal(int row, int col) {
        int count = 0;
        String symbol = currentPlayer.getRepresentation();

        int startRow = row;
        int startCol = col;
        while (startRow > 0 && startCol > 0) {
            startRow--;
            startCol--;
        }

        while (startRow < ROWS && startCol < COLS) {
            if (board[startRow][startCol].getRepresentation().equals(symbol)) {
                count++;
                if (count == WIN_COUNT) return true;
            } else {
                count = 0;
            }
            startRow++;
            startCol++;
        }
        return false;
    }

    private boolean checkAntiDiagonal(int row, int col) {
        int count = 0;
        String symbol = currentPlayer.getRepresentation();

        int startRow = row;
        int startCol = col;
        while (startRow > 0 && startCol < COLS - 1) {
            startRow--;
            startCol++;
        }

        while (startRow < ROWS && startCol >= 0) {
            if (board[startRow][startCol].getRepresentation().equals(symbol)) {
                count++;
                if (count == WIN_COUNT) return true;
            } else {
                count = 0;
            }
            startRow++;
            startCol--;
        }
        return false;
    }

    @Override
    protected boolean isGameOver() {
        if (hasWinner) return true;
        for (int col = 0; col < COLS; col++) {
            if (findLowestEmptyRow(col) != -1) {
                return false;
            }
        }
        return true;
    }
}