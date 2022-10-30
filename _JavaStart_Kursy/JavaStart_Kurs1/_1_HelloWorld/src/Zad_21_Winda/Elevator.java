package Zad_21_Winda;

class Elevator {
    private Person[] people = new Person[4];
    private int peopleNumber = 0;
    private final int maxWeight = 400;

    void add(Person person) {
        if (peopleNumber < people.length) {
            int i = peopleNumber;
            people[i] = person;
            peopleNumber++;
        } else {
            System.out.println("W windzie nie ma ju¿ miejsca.");
        }
    }

    void start() {
        if (getTotalWeight() > maxWeight) {
            System.out.println("Uwaga! Winda przeci¹¿ona o " + (getTotalWeight()-maxWeight) + " kg");
        } else {
            System.out.printf("""
                    Winda wystartowa³a. Iloœæ osób: %s. £¹czna waga: %s.
                    """, peopleNumber, getTotalWeight());
        }
    }

    int getTotalWeight() {
        int total = 0;
        for (Person person : people) {
            if (person == null) continue;
            total += person.getWeight();
        }
        return total;
    }

    void clear() {
        people = new Person[4];
    }
}
