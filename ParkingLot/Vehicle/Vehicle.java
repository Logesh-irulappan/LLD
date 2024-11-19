package ParkingLot.Vehicle;

public class Vehicle {
    private String numberPlate;
    private VehicleType vehicleType;

    public Vehicle(String numberPlate, VehicleType vehicleType) {
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

}
