package Zad_38_SklepKomputerowy;

class DataStore {
    private Computer[] computers = new Computer[100];
    private int addedComputers = 0;

    void add(Computer computer) {
        computers[addedComputers] = computer;
        addedComputers++;
    }

    public Computer[] getComputers() {
        return computers;
    }

    int checkAvailability(Computer computer) {
        int num = 0;
        for (Computer cmp : computers) {
            if (cmp == null) continue;
            if (cmp.equals(computer)) num++;
        }
        return num;
    }

    @Override
    public String toString() {
        String data = "W bazie znajduje siê " + addedComputers + " komputerów.\n";

        for (Computer computer : computers) {
            if (computer == null) continue;
            data += computer.toString();
        }
        return data;
    }
}
