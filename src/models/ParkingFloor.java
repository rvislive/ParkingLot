package models;

import java.util.List;

public class ParkingFloor extends BaseModel {
    private int number;
    private List<ParkingSpot> parkingSpots;
    private List<ParkingSpotStatus> parkingSpotStatus;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public List<ParkingSpotStatus> getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(List<ParkingSpotStatus> parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }
}
