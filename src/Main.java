
import Controller.GomokuController;
import Model.GomokuModel;
import board.BoardGame;
import games.ConnectFour;
import games.Gomoku;
import games.TicTacToe;
import players.Player;
import ui.InteractionUtilisateur;
import ui.View;
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
        view.displayGameModeMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        Player[] players = new Player[2];
        switch (choice) {
            case 1:
                players[0] = new HumanPlayer("X", view);
                players[1] = new HumanPlayer("O", view);
                break;
            case 2:
                players[0] = new HumanPlayer("X", view);
                players[1] = new ArtificialPlayer("O", view);
                break;
            case 3:
                players[0] = new ArtificialPlayer("X", view);
                players[1] = new ArtificialPlayer("O", view);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        GomokuModel model = new GomokuModel(players);
        GomokuController controller = new GomokuController(model, view);
        controller.startGame();

    }
}