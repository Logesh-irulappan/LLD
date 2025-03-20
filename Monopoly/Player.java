package Monopoly;

import Monopoly.place.Place;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String id;

    private double balance;
    private List<Place> ownedPlaces;

    public Player(String name, String id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        ownedPlaces = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void addPlace(Place place) {
        ownedPlaces.add(place);
    }

    public boolean checkOwned(Place place) {
        return ownedPlaces.contains(place);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
