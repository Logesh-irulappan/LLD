package Monopoly.place;

import Monopoly.Player;

public class Go extends Place {
    public Go(String name, String id, Place next) {
        super(name, id, next);
    }

    public Go(String name, String id) {
        super(name, id);
    }

    @Override
    public void action(Player player) {
        player.addBalance(200);
        System.out.println("Go, your balance is increased by $200 with GO");
    }
}
