import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TicketController {

    /**
     * Napisz program, który będzie symulował rolę kontrolera biletów.
     * Bilety przydzielane są w postaci elektronicznej i mają ograniczony czas ważności.
     *
     * Zdefiniuj klasy:
     *     Ticket - reprezentuje bilet, przechowuje informację o czasie skasowania biletu oraz czasie jego
     *     ważności (wyrażonej w minutach). Ponieważ bilety sprzedawane są wyłącznie w formie elektronicznej,
     *     to bilet po zakupie jest od razu "skasowany",
     *
     *     Passenger - reprezentującą pasażera. Przechowuje informacje o imieniu i nazwisku. Może mieć także przypisan
     *     obiekt Ticket, co oznacza, że dany pasażer zakupił bilet.
     *
     *     TicketMachine - reprezentuje automat do biletów. Posiada tylko jedną metodę buyTicket, która przyjmuje
     *     jako argumenty pasażera oraz czas na jaki dany pasażer wykupuje bilet a jej zadaniem jest
     *     utworzenie biletu i przypisanie go do przekazanego obiektu pasażera.
     *
     * W klasie TicketController, która powinna być klasą startową programu utwórz tablicę pasażerów i do części
     * z nich przypisz bilety (z czego niektóre bilety powinny być "przeterminowane"). Zdefiniuj osobną metodę,
     * która posłuży do sprawdzenia, którzy pasażerowie posiadają ważny bilet. W wyniku metoda powinna zwrócić
     * tablicę pasażerów, którzy nie posiadają ważnego biletu.
     */


    public static void main(String[] args) {
        Passenger p1 = new Passenger("Jan", "Kowalski");
        Passenger p2 = new Passenger("Anna", "Zawadzka");
        Passenger p3 = new Passenger("Adam", "Albonie");
        Passenger p4 = new Passenger("Zygmunt", "Hajzer");
        Passenger p5 = new Passenger("Adam", "Mickiewicz");
        Passenger p6 = new Passenger("Marcin", "Luter");

        Passenger[] passengers = {p1, p2, p3, p4, p5, p6};

        TicketMachine.buyTicket(p1, 50);
        TicketMachine.buyTicket(p2, 10);
        TicketMachine.buyTicket(p3, 15);
//        TicketMachine.buyTicket(p4, 5);
        TicketMachine.buyTicket(p5, 1);
        TicketMachine.buyTicket(p6, 20);

        Passenger[] passengersWithInvalidTicket = getPassengersWithInvalidTicket(passengers);
        System.out.println("Lista pasażerów z nieważnymi biletami:");
        if (passengersWithInvalidTicket.length == 0) {
            System.out.println("(wszyscy pasażerowie mają ważne bilety)");
        }
        for (Passenger passenger : passengersWithInvalidTicket) {
            System.out.println("- " + passenger);
        }
    }

    private static Passenger[] getPassengersWithInvalidTicket(Passenger[] passengers) {
        return Arrays.stream(passengers)
                .filter(TicketController::checkTicket)
                .toArray(Passenger[]::new);

    }

    private static boolean checkTicket(Passenger passenger) {
        if (passenger.getTicket() == null) {
            return true;
        }
        LocalDateTime startTicketTime = passenger.getTicket().getValidationTime();
        Duration durationTime = passenger.getTicket().getDurationTime();
        LocalDateTime endOfTicketTime = startTicketTime.plus(durationTime);
        return Duration.between(LocalDateTime.now(), endOfTicketTime).isNegative();
    }
}
