package ui;

import java.util.Scanner;
import players.Player;
import players.HumanPlayer;
import players.ArtificialPlayer;


public class InteractionUtilisateur {
    private final Scanner scanner;

    public InteractionUtilisateur() {
        scanner = new Scanner(System.in);
    }

    public int getGameModeChoice() {
        return scanner.nextInt();
    }

    public int[] getPlayerMove() {
        int[] coordinates = new int[2];
        coordinates[0] = scanner.nextInt() - 1;
        coordinates[1] = scanner.nextInt() - 1;
        return coordinates;
    }

    public int getColumnChoice() {
        return scanner.nextInt() - 1;
    }

//    public Player[] createPlayers(int choice, View view) {
//        Player[] players = new Player[2];
//
//        switch (choice) {
//            case 1:
//                players[0] = new HumanPlayer("X", this, view);
//                players[1] = new HumanPlayer("O", this, view);
//                break;
//            case 2:
//                players[0] = new HumanPlayer("X", this, view);
//                players[1] = new ArtificialPlayer("O", view);
//                break;
//            case 3:
//                players[0] = new ArtificialPlayer("X", view);
//                players[1] = new ArtificialPlayer("O", view);
//                break;
//        }
//        return players;
//    }
}