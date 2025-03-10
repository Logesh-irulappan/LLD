package HotelManagement;

public class Room {
    private String id;
    private RoomType type;
    private double price;
    private RoomStatus status;

    public Room(String id, RoomType type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
        status = RoomStatus.AVAILABLE;
    }

    public void book() {
        if (status == RoomStatus.AVAILABLE)
            status = RoomStatus.BOOKED;
        else
            throw new IllegalStateException("Room is Not Available for booking.");
    }

    public void checkIn() {
        if (status == RoomStatus.BOOKED)
            status = RoomStatus.OCCUPIED;
        else
            throw new IllegalStateException("Room is not yet booked.");
    }

    public void checkOut() {
        if (status == RoomStatus.OCCUPIED)
            status = RoomStatus.AVAILABLE;
        else
            throw new IllegalStateException("Room is not Occupied");
    }

    public String getId() {
        return id;
    }

    public RoomType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public RoomStatus getStatus() {
        return status;
    }
}
