package Zad_20_KinoKasaBiletowa;

class Ticket {
    private static int id;
    private Client client;
    private FilmShow filmShow;

    Ticket(Client client) {
        id++;
        this.client = client;
        this.filmShow = client.getFilmShow();
        displayTicket();
    }

    private void displayTicket() {
        System.out.printf(
                "%3s | %21s | %s - %s - %smin | Sala: %s\n",
                id,
                client.getFullName(),
                filmShow.getMovie().getTitle(),
                filmShow.getMovie().getType(),
                filmShow.getMovie().getTime(),
                filmShow.getHall().getNumber()
        );
    }
}
