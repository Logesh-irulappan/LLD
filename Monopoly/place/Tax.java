package Monopoly.place;

import Monopoly.Player;

public class Tax extends Place {

    private double taxValue;

    public Tax(String name, String id, double taxValue) {
        super(name, id);
        this.taxValue = taxValue;
    }

    public Tax(String name, String id, Place next, double taxValue) {
        super(name, id, next);
        this.taxValue = taxValue;
    }

    @Override
    public void action(Player player) {
        System.out.println("Tax of $"+ taxValue + " is Deducted from your Account Balance!");
        player.deductBalance(taxValue);
    }

    public double getTaxValue() {
        return taxValue;
    }
}
