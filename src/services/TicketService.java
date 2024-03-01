package services;

import exceptions.NoAvailableParkingSpotException;
import models.*;
import repository.TicketRepository;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;
import strategies.spotAssignment.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public TicketService(TicketRepository ticketRepository, SpotAssignmentStrategy spotAssignmentStrategy, ParkingLotRepository parkingLotRepository, ParkingSpotRepository parkingSpotRepository) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Ticket createTicket(Vehicle vehicle, Gate gate) throws NoAvailableParkingSpotException {

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getOperator());
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(ParkingLotRepository.getParkingLotForGate(gate), vehicle.getVehicleType());
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        ParkingSpotRepository.save(parkingSpot);

        ticket.setParkingSpot(parkingSpot);
        return TicketRepository.save(ticket);
    }
}
