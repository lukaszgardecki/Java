package Zad_20_KinoKasaBiletowa;

class FilmShow {
    private Movie movie;
    private CinemaHall hall;

    public FilmShow(Movie movie, CinemaHall hall) {
        this.movie = movie;
        this.hall = hall;
    }

    @Override
    public String toString() {
        return String.format("""
                        Film: %s
                        Sala: %s
                        Liczba pozosta³ych biletów: %s
                        Liczba sprzedanych biletów: %s
                        ------------------------------
                        """,
                movie.getTitle(),
                hall.getNumber(),
                hall.getFreeSeats(),
                hall.getMaxSeats() - hall.getFreeSeats()
        );
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaHall getHall() {
        return hall;
    }

    public void setHall(CinemaHall hall) {
        this.hall = hall;
    }
}
