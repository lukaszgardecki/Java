package Zad_19_AplikacjaSklepowa;

class PrintService {
    void displayInfo(Client client, double price, double discountPrice) {
        String greeting = getGreeting(client);

        System.out.printf("""
                        %s!
                        Kwota przed rabatem: %s
                        Do zap³aty (po rabacie): %s
                        """,
                greeting, price, discountPrice
        );
    }

    private String getGreeting(Client client) {
        if (client.getFirstName() == null && client.getLastName() == null) {
            return "Witaj nieznajomy";
        } else if (client.getFirstName() == null) {
            return "Dzieñ dobry panie/pani " + client.getLastName();
        } else if (client.getLastName() == null) {
            return "Witaj " + client.getFirstName();
        } else {
            return String.format("Witaj %s %s", client.getFirstName(), client.getLastName());
        }
    }
}
