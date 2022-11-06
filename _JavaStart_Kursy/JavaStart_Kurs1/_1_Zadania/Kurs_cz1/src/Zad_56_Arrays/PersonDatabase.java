package Zad_56_Arrays;

import java.util.Arrays;

class PersonDatabase {
    private Person[] people = new Person[1];
    private int addedPeople = 0;

    void add(Person p) {
        if (addedPeople == people.length) {
            people = Arrays.copyOf(people, 2 * addedPeople);
        }

        if (p == null) {
            throw new NullPointerException("Nie mo¿na dodaæ takiej osoby!");
        } else {
            people[addedPeople] = p;
            addedPeople++;
        }
    }

    void remove(Person p) {
        if (p == null) {
            throw new NullPointerException("Nie mo¿na usun¹æ takiej osoby!");
        } else {
            for (int i = 0; i < people.length; i++) {
                if (people[i] == null) continue;
                if (people[i].equals(p)) {
                    System.arraycopy(people, i+1, people, i, people.length - i - 1);
                    addedPeople--;
                }
            }
        }
    }

    Person get(int index) {
        if (index >= 0 && index < people.length) {
          return people[index];
        }
        throw new NullPointerException("B³êdny indeks.");
    }

    int size() {
        return addedPeople;
    }

    @Override
    public String toString() {
        return Arrays.toString(people);
    }
}
