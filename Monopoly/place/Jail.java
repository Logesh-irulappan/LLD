package Monopoly.place;

import Monopoly.Player;

public class Jail extends Place {

    public Jail(String name, String id, Place next) {
        super(name, id, next);
    }

    public Jail(String name, String id) {
        super(name, id);
    }

    @Override
    public void action(Player player) {
        System.out.println("You're in Jail");
    }

}
