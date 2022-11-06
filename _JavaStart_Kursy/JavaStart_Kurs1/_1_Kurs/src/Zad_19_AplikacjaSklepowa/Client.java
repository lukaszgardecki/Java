package Zad_19_AplikacjaSklepowa;

class Client {
    private String firstName;
    private String lastName;
    private boolean premium;

    Client(String firstName, String lastName, boolean premium) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.premium = premium;
    }

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    boolean isPremium() {
        return premium;
    }

    void setPremium(boolean premium) {
        this.premium = premium;
    }
}
