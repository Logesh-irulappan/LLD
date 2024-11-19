package ParkingLot;

import ParkingLot.Vehicle.Car;
import ParkingLot.Vehicle.MotorCycle;
import ParkingLot.Vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(1, 5);
        parkingLot.addLevel(2, 5);

        Vehicle car = new Car("TN59CM0414");
        Vehicle bike = new MotorCycle("TN59CM0102");
        Vehicle bike1 = new MotorCycle("TN50CM2004");
        Vehicle bike2 = new MotorCycle("TN50CM2004");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(bike);
        parkingLot.parkVehicle(bike1);
        parkingLot.parkVehicle(bike2);

        parkingLot.Availability();

        parkingLot.unParkVehicle(bike);

        parkingLot.Availability();

    }
}
