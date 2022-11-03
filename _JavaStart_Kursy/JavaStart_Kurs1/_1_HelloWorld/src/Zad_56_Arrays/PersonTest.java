package Zad_56_Arrays;

import java.util.Arrays;

class PersonTest {
    public static void main(String[] args) {
        PersonDatabase db = new PersonDatabase();

        Person person1 = new Person("Jan", "Kowalski", "12345678900");
        Person person2 = new Person("Anna", "Niewiadomska", "354657687980");
        Person person3 = new Person("Kazimierz", "Kazimierski", "357890598342");
        Person person4 = new Person("Kamil", "Chamil", "189024837465");
        Person person5 = new Person("Krzysztof", "Zawalidroga", "684736475098");

        db.add(person1);
        db.add(person2);
        db.add(person3);
        db.add(person4);
        db.add(person5);

        //Wy�wietlamy zawarto�� tablicy
        System.out.println(db);

        // wielko�� tablicy powinna wynosi�: 5
        System.out.println("Wielko�� tablicy wynosi: " + db.size());

        //Chcemy wy�wietli� Krzysztofa Z.
        System.out.println(db.get(4));

        //Usuwamy Ann� z tablicy;
        db.remove(person2);

        //Wy�wietlamy zawarto�� tablicy (bez Anny)
        System.out.println(db);

        //dodajemy now� osob�
        db.add(new Person("Szklanka", "Si�strzaska�a", "665544332211"));

        //Wy�wietlamy zawarto�� tablicy
        System.out.println(db);

    }
}
