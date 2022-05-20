public class Main {
    public static void main(String[] args) {
        //słowo public oznacza że jest to publicznie dostępne i widoczne w innych klasach
        //słowo static oznacza, śe metoda jest statyczna, czyli ta metoda jest widoczna na poziomie całej klasy
        //słowo void oznacza, że metoda nic nie zwraca
        //słowo main to nazwa metody
        //w nawiasie są parametry metody

        //Tworzę nowy obiekt:
        Person pawel = new Person();
        pawel.name = "Paweł";
        pawel.age = 18;
        pawel.isAlive = true;
        pawel.isWorking = true;

        //Tworzę nowy obiekt:
        Person mikolaj = new Person();
        mikolaj.name = "Mikołaj";
        mikolaj.age = 100;
        mikolaj.isAlive = false;

        //chciałbym żeby paweł się przedstawił, używamy metody
        pawel.przedstawSie();

        //chciałbym żeby mikołaj się przedstawił:
        mikolaj.przedstawSie();

    }
}
