package HotelManagement;

import HotelManagement.Payments.Payment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HotelManagementSystem {
    private static HotelManagementSystem instance;
    private final Map<String, Guest> guestMap;
    private final Map<String, Room> roomMap;
    private final Map<String, Reservation> reservationMap;

    private HotelManagementSystem() {
        this.guestMap = new HashMap<>();
        this.roomMap = new HashMap<>();
        this.reservationMap = new HashMap<>();
    }

    public static HotelManagementSystem getInstance() {
        if (instance == null)
            instance = new HotelManagementSystem();
        return instance;
    }

    public void addGuest(Guest guest) {
        guestMap.put(guest.getId(), guest);
        System.out.println("New Guest added successfully");
    }

    public Guest getGuest(String guestId) {
        return guestMap.get(guestId);
    }

    public void addRoom(Room room) {
        roomMap.put(room.getId(), room);
        System.out.println("New room added");
    }

    public Room getRoom(String roomId) {
        return roomMap.get(roomId);
    }

    public Reservation bookRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        if (room.getStatus() == RoomStatus.AVAILABLE) {
            room.book();
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId, guest, room, checkInDate, checkOutDate);
            reservationMap.put(reservationId, reservation);
            return reservation;
        }
        return null;
    }

    public void cancelReservation(String reservationId) {
        Reservation reservation = reservationMap.get(reservationId);
        if (reservation != null) {
            reservation.cancel();
            System.out.println("ReservationId: "+ reservationId +", reservation is cancelled");
            reservationMap.remove(reservationId);
        }
    }

    public void checkIn(String reservationId) {
        Reservation reservation = reservationMap.get(reservationId);
        if (reservation != null && reservation.getStatus() == ReservationStatus.CONFIRMED) {
            reservation.getRoom().checkIn();
        }
        else
            throw new IllegalStateException("Invalid reservation or reservation is not confirmed");
    }

    public void checkOut(String reservationId, Payment payment) {
        Reservation reservation = reservationMap.get(reservationId);
        if (reservation != null && reservation.getStatus() == ReservationStatus.CONFIRMED) {
            Room room = reservation.getRoom();
            double amount = room.getPrice() * ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
            if (payment.processPayment(amount)) {
                room.checkOut();
                reservationMap.remove(reservationId);
            }
            else {
                throw new IllegalStateException("Payment Failed.");
            }
        }
        else {
            throw new IllegalStateException("Invalid reservation or reservation not confirmed");
        }
    }

    public String generateReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

}
































