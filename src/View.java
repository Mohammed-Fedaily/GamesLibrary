public class View {
    public void displayBoard(Cell[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        System.out.print("  ");
        for (int j = 0; j < cols; j++) {
            System.out.print("   "+(j + 1 ));
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1 + "  ");
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j].getRepresentation());
            }
            System.out.println("|");
        }

        System.out.println("-".repeat(cols * 4 + 3));
    }

        public void displayCurrentPlayer(Player player) {
        System.out.println("Is: " + player.getRepresentation().replace("|","")+"turn");
    }

    public void displayInvalidMove() {
        System.out.println("What this dumbass ni***?! Try again.");
    }

    public void displayWinner(Player player) {
        System.out.println("heeeey!!" + player.getRepresentation().replace("|","") + "you win!");
    }

    public void displayDraw() {
        System.out.println("Woohoooo!!! You are both tough!");
    }

    public void displayGameModeMenu() {
        System.out.println("Choose game mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs COM");
        System.out.println("3. COM vs COM");
    }

    public void displayGameSelectionMenu() {
        System.out.println("Choose your game:");
        System.out.println("1. TicTacToe");
        System.out.println("2. Gomoku");
        System.out.println("3. Connect 4");

    }
    public void displayMovePrompt(Player player) {
        System.out.println("You " + player.getRepresentation().replace("|","") +
                ", enter your move : ");
    }

    public void displayComMove(int row, int col) {
        System.out.println("COM plays: " + (row + 1) + " " + (col + 1));
    }

    public void displayColumnPrompt(Player player) {
        System.out.println(player.getRepresentation().replace("|", "").trim() +
                ", choose a column");
    }

    public void displayComColumnMove(int col) {
        System.out.println("COM plays in column: " + (col + 1));
    }
}