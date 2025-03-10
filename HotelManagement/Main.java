package HotelManagement;

import HotelManagement.Payments.CashPayment;
import HotelManagement.Payments.Payment;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        HotelManagementSystem system = HotelManagementSystem.getInstance();

        // Creating guests
        Guest guest1 = new Guest("14", "LOGESH", "logesh@gmail.com", "9789241416");
        Guest guest2 = new Guest("04", "MAHITHA", "mahitha@gmail.com", "7418454003");
        system.addGuest(guest1);
        system.addGuest(guest2);

        // Creating rooms
        Room room1 = new Room("R101", RoomType.SINGLE, 1000.0);
        Room room2 = new Room("R102", RoomType.DOUBLE, 2000.0);
        system.addRoom(room1);
        system.addRoom(room2);

        LocalDate checkIn = LocalDate.now();
        LocalDate checkOut = checkIn.plusDays(3);

        Reservation reservation = system.bookRoom(guest1, room2, checkIn, checkOut);
        if (reservation != null) {
            System.out.println("Reservation created: "+ reservation.getId());
        }
        else {
            System.out.println("Room not available for booking.");
            return;
        }

        system.checkIn(reservation.getId());
        System.out.println("check in: "+ checkIn);

        Payment payment = new CashPayment();
        system.checkOut(reservation.getId(), payment);
        System.out.println("Check out: "+ checkOut);

        system.cancelReservation(reservation.getId());
        System.out.println("Reservation cancelled: "+ reservation.getId());
    }
}
