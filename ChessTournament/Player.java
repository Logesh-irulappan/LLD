package ChessTournament;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private String name;
    private int totalPoints;

    private boolean available;

    private List<Integer> opponents;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        totalPoints = 0;
        opponents = new ArrayList<>();
        available = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addOpponent(Player player) {
        opponents.add(player.getId());
    }

    public boolean containsOpponent(Player player) {
        return opponents.contains(player.getId());
    }

    public List<Integer> getOpponents() {
        return opponents;
    }

    public boolean isAvailable() {
        return available;
    }

    public void changeAvailability() {
        available = !available;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void addPoints(int points) {
        this.totalPoints += points;
    }
}
