public class Person {

        //Tworzymy osobę Person
        //ta osoba ma imię, wiek i informcję czy żyje i czy pracuje
        //czyli ta klasa (Person) posiada pola name, age, isAlive, isWorking
    String name;
    int age;
    boolean isAlive;
    boolean isWorking;

    //w klasie person deklaruję metodę, która nic nie zwraca
    //dzięki tej metodzie, każda z osób będzie miała możliwość przedstawienia się
    //każdy obiekt klasy Person potrafi się przedstawić
    void przedstawSie() {
        System.out.println("Cześć jestem " + name  + ", mam" + age + " lat.");
    }

}
