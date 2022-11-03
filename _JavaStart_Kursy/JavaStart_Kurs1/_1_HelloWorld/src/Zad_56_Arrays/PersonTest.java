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

        //Wyœwietlamy zawartoœæ tablicy
        System.out.println(db);

        // wielkoœæ tablicy powinna wynosiæ: 5
        System.out.println("Wielkoœæ tablicy wynosi: " + db.size());

        //Chcemy wyœwietliæ Krzysztofa Z.
        System.out.println(db.get(4));

        //Usuwamy Annê z tablicy;
        db.remove(person2);

        //Wyœwietlamy zawartoœæ tablicy (bez Anny)
        System.out.println(db);

        //dodajemy now¹ osobê
        db.add(new Person("Szklanka", "Siêstrzaska³a", "665544332211"));

        //Wyœwietlamy zawartoœæ tablicy
        System.out.println(db);

    }
}
