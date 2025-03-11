package ChessTournament;

import java.util.*;

public class Committee {

    public static Committee instance;

    Map<Integer, Player> AllPlayers;
    List<Match> matchList;
    Player[] players;

    private Committee() {
        AllPlayers = new HashMap<>();
    }

    public static Committee getInstance() {
        if (instance == null)
            instance = new Committee();
        return instance;
    }

    public void startMatch(int numberOfPlayers, int numberOfRounds) {
        players = new Player[numberOfPlayers];
        for (int i = 1; i <= numberOfPlayers; i++) {
            String name = "PLAYER" + i;
            Player player = new Player(i, name);
            players[i-1] = player;
            AllPlayers.put(i, player);
        }
        System.out.println("Players created");

        for (int i = 0; i < numberOfRounds; i++) {
            pairing();
            makeMatchResults();
            sortPlayers();
        }
        calculateCumulativeScore();
    }

    public void calculateCumulativeScore() {
        System.out.println("\n--- CUMULATIVE SCORE ---");

        for (Player player : players) {
            List<Integer> opponentsId = player.getOpponents();
            int curCumulativeScore = 0;
            for (int i = 0; i < opponentsId.size(); i++) {
                curCumulativeScore += AllPlayers.get(opponentsId.get(i)).getTotalPoints();
            }
            System.out.println(player.getName() +" -> cumaltive score: "+ curCumulativeScore);
        }
    }

    public void pairing() {
        matchList = new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            if (player.isAvailable())
                continue;

            for (int j = 0; j < players.length; j++) {
                Player opponent = players[j];
                if (opponent.isAvailable() || player.getId() == opponent.getId() || opponent.containsOpponent(player))
                    continue;
                else {
                    Match match = new Match(player, opponent);
                    player.changeAvailability();
                    opponent.changeAvailability();

                    player.addOpponent(opponent);
                    opponent.addOpponent(player);

                    matchList.add(match);
                    break;
                }
            }
        }

        printMatchBoard();
    }

    public void makeMatchResults() {
        int index = 0;
        for (Match match : matchList) {
            if (index % 2 == 0) {
                match.setStatus(MatchStatus.PLAYER1_WINS);
                match.getPlayer1().addPoints(1);

                match.getPlayer1().changeAvailability();
                match.getPlayer2().changeAvailability();
            }
            else {
                match.setStatus(MatchStatus.PLAYER2_WINS);
                match.getPlayer2().addPoints(1);

                match.getPlayer1().changeAvailability();
                match.getPlayer2().changeAvailability();
            }
            index++;
        }
        printResultBoard();
    }

    public void sortPlayers() {
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players.length; j++) {
                if (players[i].getTotalPoints() > players[j].getTotalPoints()) {
                    Player temp = players[i];
                    players[i] = players[j];
                    players[j] = temp;
                }
            }
        }
        printPlayers();
    }

    public void printPlayers() {
        int rankCount = 1;
        System.out.println("\n--- RANK BOARD ---");
        for (Player player : players) {
            System.out.println("Rank: "+rankCount +" "+ player.getName() +" Points: "+ player.getTotalPoints());
            rankCount++;
        }
    }

    public void printResultBoard() {
        System.out.println("\n--- RESULT BOARD ---");
        for (Match match : matchList) {
            if (match.getStatus() == MatchStatus.PLAYER1_WINS)
                System.out.println(match.getPlayer1Name()+" (1:0) "+ match.getPlayer2Name());
            else
                System.out.println(match.getPlayer1Name()+" (0:1) "+ match.getPlayer2Name());
        }
    }

    public void printMatchBoard() {
        System.out.println("\n--- MATCH BOARD ---");
        for (Match match : matchList) {
            System.out.println(match.getPlayer1Name() + "  (VS)  "+ match.getPlayer2Name());
        }

        for (Player player : players) {
            if (!player.isAvailable()) {
                System.out.println(player.getName()+" GETS A BYE ");
            }
        }

        System.out.println();
    }

}
