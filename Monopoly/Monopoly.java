package Monopoly;

import Monopoly.place.Go;
import Monopoly.place.Place;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Monopoly {

    private Map<String, Player> playerList;
    private Place head;
    private Scanner in = new Scanner(System.in);

    public Monopoly() {
        playerList = new HashMap<>();
        head = new Go("GO", "PLACE1", null);
    }

    public void startGame() {
        createPlayers();
    }

    private void createPlayers() {
        System.out.println("Enter no of players: ");
        int numberOfPlayers = in.nextInt();

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Enter Player "+ i +" name: ");
            String name = in.nextLine();
            String id = "PLAYER" + i;

            Player player = new Player(name, id, 0);
            playerList.put(id, player);
        }
    }

    private void makeBoard() {

    }

}























