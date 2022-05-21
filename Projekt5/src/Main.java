public class Main {
    public static void main(String[] args) {
        //słowo public oznacza że jest to publicznie dostępne i widoczne w innych klasach
        //słowo static oznacza, śe metoda jest statyczna, czyli ta metoda jest widoczna na poziomie całej klasy
        //słowo void oznacza, że metoda nic nie zwraca
        //słowo main to nazwa metody
        //w nawiasie są parametry metody, metoda main przyjmuje jeden argument w postaci tablicy o nazwie "args"

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


        pawel.przedstawSie(false);   //chciałbym żeby paweł się przedstawił nieformalnie, używamy metody przedstawSię()
        mikolaj.przedstawSie(false); //chciałbym żeby mikołaj się przedstawił nieformalnie
        pawel.przedstawSie(true);   //chciałbym żeby paweł się przedstawił jeszcze raz ale formalnie, używamy metody

        int ileRazy = pawel.ileRazyPrzedstawili(); //policz ile razy osoby się przedstawiły

        System.out.println("Pawel przedstawił się " + ileRazy + " razy."); //wyświetl na ekranie ile razy osoby się przedstawiły

    }
}
