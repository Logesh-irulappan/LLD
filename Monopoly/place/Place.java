package Monopoly.place;

import Monopoly.Player;

public class Place {
    private String name;
    private String id;

    private Place next;

    public Place(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Place(String name, String id, Place next) {
        this.name = name;
        this.id = id;
        this.next = next;
    }

    public void setNext(Place place) {
        this.next = place;
    }

    public void action(Player player) {
        System.out.println("Action tooks place at Place class");
    }

    public String getPlaceId() {
        return id;
    }

    public String getPlaceName() {
        return name;
    }
}
