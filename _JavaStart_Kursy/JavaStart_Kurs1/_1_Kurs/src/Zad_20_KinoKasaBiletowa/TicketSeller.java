package Zad_20_KinoKasaBiletowa;

class TicketSeller {

    static void sellTicket(Client client) {
        FilmShow filmShow = client.getFilmShow();
        Movie movie = filmShow.getMovie();
        CinemaHall hall = filmShow.getHall();

        if (hall.getFreeSeats() == 0) {
            System.out.println("Brak wolnych miejsc na seans");
        } else if (client.getAge() < movie.getAgeRequired()) {
            System.out.println("Film dostêpny dla osób powy¿ej " + movie.getAgeRequired() + " lat");
        } else {
            new Ticket(client);
            hall.setFreeSeats(hall.getFreeSeats() - 1);
        }
    }

}
