package models;

import java.util.List;

public class ParkingSpot extends BaseModel {
    private int number;
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingFloor parkingFloor;

    private List<VehicleType> vehiclesType;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public List<VehicleType> getVehiclesType() {
        return vehiclesType;
    }

    public void setVehiclesType(List<VehicleType> vehiclesType) {
        this.vehiclesType = vehiclesType;
    }

}
