public class Main {
    public static void main(String[] args) {
        View view = new View();
        InteractionUtilisateur interaction = new InteractionUtilisateur();


        view.displayGameSelectionMenu();
        int gameChoice = interaction.getGameModeChoice();

        view.displayGameModeMenu();
        int modeChoice = interaction.getGameModeChoice();

        Player[] players = interaction.createPlayers(modeChoice, view);

        BoardGame game = null;
        switch(gameChoice) {
            case 1:
                game = new TicTacToe(players, view);
                break;
            case 2:
                game = new Gomoku(players, view);
                break;
            case 3:
                game = new ConnectFour(players, view);
                break;
            default:
                System.out.println("Invalid game choice!");
                return;
        }

        game.play();
    }
}