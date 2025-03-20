package Monopoly.place;

import Monopoly.Player;

public class Railroad extends Place {

    private double rentValue;

    public Railroad(String name, String id, Place next, double rentValue) {
        super(name, id, next);
        this.rentValue = rentValue;
    }

    public Railroad(String name, String id, double rentValue) {
        super(name, id);
        this.rentValue = rentValue;
    }

    @Override
    public void action(Player player) {
        System.out.println("Railroad rent is collected from you!");
        player.deductBalance(rentValue);
    }

    public void setRentValue(double rentValue) {
        this.rentValue = rentValue;
    }

    public double getRentValue() {
        return rentValue;
    }

}
