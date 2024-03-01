package strategies.feeCalculation;

import models.Bill;
import models.Ticket;

import java.util.Calendar;

public class HourlyFeeCalculationStrategy implements FeeCalculationStrategy {

    @Override
    public float calculateFee(Ticket ticket, Bill bill) {
        return 0;
    }
}
