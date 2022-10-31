package Zad_38_SklepKomputerowy;

class NotebookShop {
    public static void main(String[] args) {
        DataStore dataStore = new DataStore();

        Computer c1 = new Computer("Asus", 1234);
        Computer c2 = new Computer("Toshiba", 4354);
        Computer c3 = new Computer("MakbUk", 8181);
        Computer c4 = new Computer("Toshiba", 4354);
        Computer c5 = new Computer("Toshiba", 4354);

        dataStore.add(c1);
        dataStore.add(c2);
        dataStore.add(c3);
        dataStore.add(c4);
        dataStore.add(c5);


        System.out.println("Iloœæ takich samych komputerów: " + dataStore.checkAvailability(c2));
        System.out.println(dataStore);

    }

}
