package Zad_20_KinoKasaBiletowa;

class Client {
    private String firstName;
    private String lastName;
    private int age;
    private FilmShow filmShow;

    public Client(String firstName, String lastName, int age, FilmShow filmShow) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.filmShow = filmShow;
        TicketSeller.sellTicket(this);
    }

    public FilmShow getFilmShow() {
        return filmShow;
    }

    public void setFilmShow(FilmShow filmShow) {
        this.filmShow = filmShow;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
