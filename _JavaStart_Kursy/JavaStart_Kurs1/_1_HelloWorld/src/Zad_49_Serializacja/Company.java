package Zad_49_Serializacja;

import java.io.Serializable;

class Company implements Serializable {
    private Person[] workers = new Person[3];
    private int addedPerson = 0;

    void add(Person person) {
        workers[addedPerson] = person;
        addedPerson++;
    }
}
