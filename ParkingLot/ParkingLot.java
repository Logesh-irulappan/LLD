package ParkingLot;

import ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot() {
        levels = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null)
            instance = new ParkingLot();
        return instance;
    }

    public void addLevel(int floorNo, int totalSpots) {
        levels.add(new Level(floorNo, totalSpots));
    }

    public void parkVehicle(Vehicle vehicle) {
        for (Level level: levels) {
            if (level.parkVehicle(vehicle)) {
                System.out.println(vehicle.getVehicleType()+" Parked Successfully");
                return;
            }
        }
        System.out.println("Vehicle type is Not Valid or Could not park valid");
    }

    public void unParkVehicle(Vehicle vehicle) {
        for (Level level: levels) {
            if (level.unParkVehicle(vehicle)) {
                System.out.println(vehicle.getVehicleType()+" is Taken from Parking");
                return;
            }
            System.out.println("Vehicle is Already Taken");
        }
    }

    public void Availability() {
        for (Level level : levels)
            level.availabilityInLevel();
    }

}
