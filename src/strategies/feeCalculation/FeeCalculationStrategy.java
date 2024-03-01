package strategies.feeCalculation;

import models.Bill;
import models.Ticket;

public interface FeeCalculationStrategy {
    public float calculateFee(Ticket ticket, Bill bill);
}
