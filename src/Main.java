
import Controller.GomokuController;
import Model.GomokuModel;
import players.Player;
import View.GameView;
import View.ConsoleGameView;
import Model.TicTacToeModel;
import Controller.TicTacToeController;
import players.HumanPlayer;
import players.ArtificialPlayer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        View view = new View();
//        InteractionUtilisateur interaction = new InteractionUtilisateur();
//
//
//        view.displayGameSelectionMenu();
//        int gameChoice = interaction.getGameModeChoice();
//
//        view.displayGameModeMenu();
//        int modeChoice = interaction.getGameModeChoice();
//
//        Player[] players = interaction.createPlayers(modeChoice, view);
//
//        BoardGame game = null;
//        switch(gameChoice) {
//            case 1:
//                game = new TicTacToe(players, view);
//                break;
//            case 2:
//                game = new Gomoku(players, view);
//                break;
//            case 3:
//                game = new ConnectFour(players, view);
//                break;
//            default:
//                System.out.println("Invalid game choice!");
//                return;
//        }
//
//        game.play();
//    }

        GameView view = new ConsoleGameView();
        Scanner scanner = new Scanner(System.in);

        view.displayGameSelectionMenu();
        int gameChoice = scanner.nextInt();

        view.displayGameModeMenu();
        int modeChoice = scanner.nextInt();

        Player[] players = createPlayers(modeChoice, view);
        if (players == null) return;

        switch (gameChoice) {
            case 1:
                TicTacToeModel ticTacToeModel = new TicTacToeModel(players);
                TicTacToeController ticTacToeController = new TicTacToeController(ticTacToeModel, view);
                ticTacToeController.startGame();
                break;
            case 2:
                GomokuModel gomokuModel = new GomokuModel(players);
                GomokuController gomokuController = new GomokuController(gomokuModel, view);
                gomokuController.startGame();
                break;
            case 3:
                System.out.println("Connect Four not yet implemented!");
                break;
            default:
                System.out.println("Invalid game choice!");
        }
    }

    private static Player[] createPlayers(int modeChoice, GameView view) {
        Player[] players = new Player[2];
        switch (modeChoice) {
            case 1:
                players[0] = new HumanPlayer("X|", view);
                players[1] = new HumanPlayer("O|", view);
                break;
            case 2:
                players[0] = new HumanPlayer("X|", view);
                players[1] = new ArtificialPlayer("O|", view);
                break;
            case 3:
                players[0] = new ArtificialPlayer("X|", view);
                players[1] = new ArtificialPlayer("O|", view);
                break;
            default:
                System.out.println("Invalid mode choice!");
                return null;
        }
        return players;
    }

}