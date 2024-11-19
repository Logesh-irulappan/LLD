package ParkingLot;

import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Vehicle.VehicleType;

public class ParkingSpot {

    private int spotNumber;
    private VehicleType typeOfParkingSpot;

    private Vehicle spotVehicle;

    public ParkingSpot(int spotNumber, VehicleType typeOfParkingSpot) {
        this.spotNumber = spotNumber;
        this.typeOfParkingSpot = typeOfParkingSpot;
    }

    public boolean isAvailable() {
        return spotVehicle == null;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getVehicleType() == typeOfParkingSpot) {
            spotVehicle = vehicle;
            return true;
        }
        return false;
    }

    public boolean unParkVehicle() {
        if (!isAvailable()) {
            spotVehicle = null;
            return true;
        }
        return false;
    }

    public Vehicle getSpotVehicle() {
        return spotVehicle;
    }

    @Override
    public String toString() {
        String state = isAvailable() ? "Available for " : "Occupied by ";
        return "Spot No: "+spotNumber+ " => " + state + typeOfParkingSpot;
    }

}
