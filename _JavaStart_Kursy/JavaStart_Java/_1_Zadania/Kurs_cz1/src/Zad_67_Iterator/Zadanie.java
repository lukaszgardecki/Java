package Zad_67_Iterator;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Zadanie {
    public static void main(String[] args) {
        Map<String, Person> people = new TreeMap<>();

        Person p1 = new Person("Zygmunt", "Kowalski", 57);
        Person p2 = new Person("Jan", "Zamorski", 12);
        Person p3 = new Person("Kazimierz", "Andal", 54);
        Person p4 = new Person("Alojz", "Wojciechowski", 23);
        Person p5 = new Person("Anna", "Rydz", 52);
        Person p6 = new Person("Kamila", "Muchomor", 36);
        Person p7 = new Person("Emilia", "Motorski", 15);
        Person p8 = new Person("Izabela", "Gajewski", 7);
        Person p9 = new Person("Aneta", "Kronospan", 45);
        Person p10 = new Person("Ilona", "Egger", 88);
        Person p11 = new Person("£ukasz", "Szwarceneger", 35);
        Person p12 = new Person("Dawid", "Mickiewicz", 12);

        people.put(p1.getLastName(), p1);
        people.put(p2.getLastName(), p2);
        people.put(p3.getLastName(), p3);
        people.put(p4.getLastName(), p4);
        people.put(p5.getLastName(), p5);
        people.put(p6.getLastName(), p6);
        people.put(p7.getLastName(), p7);
        people.put(p8.getLastName(), p8);
        people.put(p9.getLastName(), p9);
        people.put(p10.getLastName(), p10);
        people.put(p11.getLastName(), p11);
        people.put(p12.getLastName(), p12);

        Iterator<Person> iterator = people.values().iterator();

        System.out.println("Pozycje wyœwietlone alfabetycznie wg nazwisk:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
