package strategies.spotAssignment;

import exceptions.NoAvailableParkingSpotException;
import models.ParkingLot;
import models.ParkingSpot;
import models.VehicleType;

public interface SpotAssignmentStrategy {

    public ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) throws NoAvailableParkingSpotException;
}
