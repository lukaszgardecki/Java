import java.time.Duration;
import java.time.LocalDateTime;

public class TicketMachine {

    static void buyTicket(Passenger passenger, int ticketTimeInMIN) {
        passenger.setTicket(new Ticket(LocalDateTime.now(), Duration.ofMinutes(ticketTimeInMIN)));
    }
}
