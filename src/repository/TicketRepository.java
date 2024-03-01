package repository;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private static Long lastCountId = 0L;
    private static HashMap<Long, Ticket> tickets = new HashMap<Long, Ticket>();
    public static Ticket save(Ticket ticket) {
        lastCountId += 1;
        tickets.put(lastCountId, ticket);
        return ticket;
    }

    public Ticket getTicketById(Long Id) {
        return tickets.get(Id);
    }
}
