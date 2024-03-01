package strategies.spotAssignment;

import exceptions.NoAvailableParkingSpotException;
import models.*;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {

    @Override
    public ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) throws NoAvailableParkingSpotException {

        for(ParkingFloor parkingFloor: parkingLot.getParkingFloors()) {
            for(ParkingSpot parkingSpot: parkingFloor.getParkingSpots()) {
                if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) && parkingSpot.getVehiclesType().contains(vehicleType)) {
                    return parkingSpot;
                }
            }
        }

        throw new NoAvailableParkingSpotException("No parking-spot available!");
    }
    
}
