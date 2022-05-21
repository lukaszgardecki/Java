public class Person {

        //Tworzymy osobę Person
        //ta osoba ma imię, wiek i informcję czy żyje i czy pracuje
        //czyli ta klasa (Person) posiada pola name, age, isAlive, isWorking
    String name;
    int age;
    boolean isAlive;
    boolean isWorking;
    int ileRazy;

    //w klasie person deklaruję metodę, która nic nie zwraca
    //dzięki tej metodzie, każda z osób będzie miała możliwość przedstawienia się
    //każdy obiekt klasy Person potrafi się przedstawić
    //do nawiasu dodam zmienną formal, która musi mieć napisany wcześniej TYP, np. boolean
    void przedstawSie(boolean formal) {
        ileRazy++;
        if (formal) {
            System.out.println("Witam Państwa bardzo serdecznie.Mam na imię " + name  + ", mam" + age + " lat.");
        } else {
            System.out.println("Cześć jestem " + name + ", mam" + age + " lat.");
        }
    }

    int ileRazyPrzedstawili() {
        return ileRazy;
    }

}
