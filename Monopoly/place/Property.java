package Monopoly.place;

import Monopoly.Player;

import java.util.Scanner;

public class Property extends Place {

    private double sellValue;
    private double rentValue;

    private Player placeOwner;

    public Property(String name, String id, Place next, double sellValue, double rentValue) {
        super(name, id, next);
        this.sellValue = sellValue;
        this.rentValue = rentValue;
        placeOwner = null;
    }

    public Property(String name, String id, double sellValue, double rentValue) {
        super(name, id);
        this.sellValue = sellValue;
        this.rentValue = rentValue;
        placeOwner = null;
    }

    @Override
    public void action(Player player) {
        Scanner in = new Scanner(System.in);

        if (isOwned()) {
            System.out.println("This place is owned by "+ placeOwner.getName() + ", rent has been deducted from your account.");
            placeOwner.addBalance(rentValue);
            player.deductBalance(rentValue);
        }
        else {
            System.out.println("Enter 1 to buy this land (or) Enter 0 to skip it: ");
            int choice = in.nextInt();
            if (choice == 1) {
                if (player.getBalance() >= sellValue) {
                    setPlaceOwner(player);
                    System.out.println("This place is successfully Registered for you");
                }
                else {
                    System.out.println("Insufficient Account balance.");
                }
            }
        }
    }

    public boolean isOwned() {
        return placeOwner != null;
    }

    public void setPlaceOwner(Player player) {
        this.placeOwner = player;
    }

    public Player getPlaceOwner() {
        return placeOwner;
    }

    public double getRentValue() {
        return rentValue;
    }

    public double getSellValue() {
        return sellValue;
    }
}
