package Zad_20_KinoKasaBiletowa;

class CinemaSystem {
    public static void main(String[] args) {
        CinemaHall hall1 = new CinemaHall(201, 72);
        CinemaHall hall2 = new CinemaHall(202, 72);
        CinemaHall hall3 = new CinemaHall(203, 72);
        CinemaHall hall4 = new CinemaHall(204, 72);
        CinemaHall hall5 = new CinemaHall(205, 72);
        CinemaHall hall6 = new CinemaHall(206, 72);

        Movie movie1 = new Movie("Omen", "horror", 128, 16);
        Movie movie2 = new Movie("Nietykalni", "dramat", 112, 16);
        Movie movie3 = new Movie("Forest Gump", "dramat", 144, 16);
        Movie movie4 = new Movie("Pulp Fiction", "gangsterski", 154, 16);
        Movie movie5 = new Movie("Django", "western", 165, 16);
        Movie movie6 = new Movie("Król Lew", "Familijny", 89, 7);

        FilmShow filmShow1 = new FilmShow(movie1, hall1);
        FilmShow filmShow2 = new FilmShow(movie2, hall2);
        FilmShow filmShow3 = new FilmShow(movie3, hall3);
        FilmShow filmShow4 = new FilmShow(movie4, hall4);
        FilmShow filmShow5 = new FilmShow(movie5, hall5);
        FilmShow filmShow6 = new FilmShow(movie6, hall6);

        System.out.println("Sprzedane bilety");

        new Client("Jan", "Kowalski", 15, filmShow1);
        new Client("Anna", "Zalewska", 19, filmShow1);
        new Client("Filip", "Zkonopii", 34, filmShow1);
        new Client("Kasia", "Rogal", 26, filmShow1);

        new Client("Marysia", "Drut", 22, filmShow2);
        new Client("Zbigniew", "Zamachowski", 54, filmShow2);
        new Client("Dawid", "Zielony", 21, filmShow2);

        new Client("Krystian", "Czerwony", 17, filmShow3);
        new Client("Pawe³", "Auto", 17, filmShow3);
        new Client("Darek", "Kartka", 17, filmShow3);
        new Client("£ukasz", "Ryba", 17, filmShow3);

        new Client("Marcin", "Stonoga", 17, filmShow4);
        new Client("Mateusz", "Morawiecki", 17, filmShow4);
        new Client("Donald", "Tusk", 12, filmShow4);
        new Client("Donald", "Tusk", 17, filmShow4);
        new Client("Donald", "Tusk", 17, filmShow4);
        new Client("Donald", "Tusk", 17, filmShow4);
        new Client("Donald", "Tusk", 107, filmShow4);
        new Client("Donald", "Tusk", 9, filmShow4);
        new Client("Donald", "Tusk", 11, filmShow4);
        new Client("Donald", "Tusk", 17, filmShow4);
        new Client("Donald", "Tusk", 17, filmShow4);
        new Client("Donald", "Tusk", 17, filmShow4);
        new Client("Donald", "Tusk", 17, filmShow4);
        new Client("Donald", "Tusk", 17, filmShow4);

        new Client("Krzysztof", "Bosak", 17, filmShow5);
        new Client("Stanis³aw", "Pan", 17, filmShow5);
        new Client("Marcin", "Komputer", 17, filmShow5);

        new Client("Alicja", "Malinowska", 10, filmShow6);
        new Client("Krystyna", "Malinowska", 12, filmShow6);
        new Client("Agnieszka", "Gnat", 15, filmShow6);
        new Client("Ania", "Dobrado", 13, filmShow6);


        System.out.println(filmShow1);
        System.out.println(filmShow2);
        System.out.println(filmShow3);
        System.out.println(filmShow4);
        System.out.println(filmShow5);
        System.out.println(filmShow6);

    }
}
