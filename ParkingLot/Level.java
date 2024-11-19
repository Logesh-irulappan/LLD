package ParkingLot;

import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private final int floorNumber;
    private List<ParkingSpot> parkingSpots;

    public Level(int floor, int totalParkingSpaces) {

        floorNumber = floor;
        parkingSpots = new ArrayList<>(totalParkingSpaces);

        double motorcycle = 0.50;
        double cars = 0.30;

        int numOfMotorcycle = (int) (motorcycle * totalParkingSpaces);
        int numOfCar = (int) (cars * totalParkingSpaces);

        for (int i = 1; i <= numOfMotorcycle; i++)
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));

        for (int i = numOfMotorcycle+1; i <= numOfMotorcycle + numOfCar; i++)
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));

        for (int i = numOfMotorcycle+numOfCar+1; i <= totalParkingSpaces; i++)
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot: parkingSpots) {
            if (spot.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot: parkingSpots) {
            if (!spot.isAvailable() && spot.getSpotVehicle().equals(vehicle)) {
                return spot.unParkVehicle();
            }
        }
        return false;
    }

    public void availabilityInLevel() {
        System.out.println("Floor: "+ floorNumber+" Availability => ");
        for (ParkingSpot spot: parkingSpots) {
            System.out.println(spot.toString());
        }
    }

}
