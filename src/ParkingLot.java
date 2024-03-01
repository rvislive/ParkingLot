import controllers.TicketController;
import dto.CreateTicketRequestDto;
import dto.CreateTicketResponseDto;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;
import repository.TicketRepository;
import services.TicketService;
import strategies.spotAssignment.RandomSpotAssignmentStrategy;
import strategies.spotAssignment.SpotAssignmentStrategy;

public class ParkingLot {
    public static void main(String[] args) {
        ObjectRegistry.register("parkingLotRepository", new ParkingLotRepository());
        ObjectRegistry.register("parkingLotRepository", new ParkingLotRepository());
        ObjectRegistry.register("parkingSpotRepository", new ParkingSpotRepository());
        ObjectRegistry.register("ticketRepository", new TicketRepository());

        ObjectRegistry.register("spotAssignmentStrategy", new RandomSpotAssignmentStrategy());
        ObjectRegistry.register("ticketService", new TicketService(
                (TicketRepository) ObjectRegistry.get("ticketRepository"),
                (SpotAssignmentStrategy) ObjectRegistry.get("spotAssignmentStrategy"),
                (ParkingLotRepository) ObjectRegistry.get("parkingLotRepository"),
                (ParkingSpotRepository) ObjectRegistry.get("parkingSpotRepository")
        ));

        ObjectRegistry.register("ticketController", new TicketController(
                (TicketService) ObjectRegistry.get("ticketService")
        ));

        /* ----------- Write your all client code here. ------------- */

        CreateTicketRequestDto request = new CreateTicketRequestDto();
        request.setGate(null);
        request.setVehicle(null);

        CreateTicketResponseDto response = ((TicketController) ObjectRegistry.get(
                "ticketController"
        )).createTicket(request);

        /*
        *
        * Implement these features in this application.
        * 1. Create a ticket.
        * 2. Create a new Parking lot.
        * 3. Add a floor to a parking lot.
        * 4. Add a entry/exit gate to a parking lot.
        *
        * */
    }
}