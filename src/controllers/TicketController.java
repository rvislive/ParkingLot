package controllers;

import dto.CreateTicketRequestDto;
import dto.CreateTicketResponseDto;
import exceptions.NoAvailableParkingSpotException;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    public CreateTicketResponseDto createTicket(CreateTicketRequestDto request) {
        try {
            Ticket ticket = ticketService.createTicket(
                request.getVehicle(),
                request.getGate()
            );

            CreateTicketResponseDto response = new CreateTicketResponseDto();
            response.setTicket(ticket);

            return response;
        } catch (NoAvailableParkingSpotException exception) {
            CreateTicketResponseDto response = new CreateTicketResponseDto();
            response.setMessage("No Spot are available.");
        }

        return null;
    }
}
