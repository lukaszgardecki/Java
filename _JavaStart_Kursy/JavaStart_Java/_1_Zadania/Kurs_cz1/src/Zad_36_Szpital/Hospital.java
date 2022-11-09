package Zad_36_Szpital;

class Hospital {
    private Person[] workers = new Person[3];
    private int employees = 0;

    void add(Person worker) {
        workers[employees] = worker;
        employees++;
    }

    String getInfo() {
        String info = "Pracownicy szpitala:\n";
        for (Person worker : workers) {
            info += worker.getInfo() + "\n";
        }
        return info;
    }
}
