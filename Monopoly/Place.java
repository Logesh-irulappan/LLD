package Monopoly;

public class Place {
    private String name;
    private String id;

    private double rentValue;
    private double sellValue;

    private boolean isOwned;
    private Player ownerId;

    public Place(String name, String id, double rentValue, double sellValue) {
        this.name = name;
        this.id = id;
        this.rentValue = rentValue;
        this.sellValue = sellValue;
        isOwned = false;
        ownerId = null;
    }

    public String getPlaceName() {
        return name;
    }

    public String getPlaceId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId.getId();
    }

    public boolean isPlaceOwned() {
        return isOwned;
    }

    public double getSellValue() {
        return sellValue;
    }

    public double getRentValue() {
        return rentValue;
    }
}
