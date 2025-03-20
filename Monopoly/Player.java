package Monopoly;

import java.util.List;
import java.util.ArrayList;

public class Player {
    private String name;
    private String id;

    private double balance;
    private int position;
    private List<Place> ownedPlaced;
    private boolean inJail;

    public Player(String name, String id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        ownedPlaced = new ArrayList<>();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isInJail() {
        return inJail;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addPlace(Place place) {
        ownedPlaced.add(place);
    }

    public boolean isPlayerHas(Place place) {
        if (ownedPlaced.isEmpty())
            return false;
        return ownedPlaced.contains(place);
    }

}

