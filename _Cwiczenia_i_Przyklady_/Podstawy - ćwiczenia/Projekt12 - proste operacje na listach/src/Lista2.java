import java.util.ArrayList;

        //---------- LISTA GENERYCZNA ---------
        // ---------- jest kolekcją --------
        //działa tak samo jak lista niegeneryczna ale daje nam te zalety, że wiemy co tam jest przechowywane, skracamy koszt wywoływania naszych operacji (metod). Ograniczamy się do tego, że piszemy nazwę naszej listy, odwołujemy się do elementu tej listy, a środowisko już wie jakie nasz obiekt posiada składowe (albo funkcje, metody lub właściwości i pola), np. imie.

public class Lista2 {
    public static void main(String[] args) {
        Animal kot1 = new Animal("Rudy");
        Animal kot2 = new Animal("Bury");
        Animal kot3 = new Animal("Bialy");

        //Tworzymy listę, nie podajemy w nawiasie rozmiaru listy bo ona domyślanie ma 0 elemetów
        ArrayList<Animal> listaG = new ArrayList<Animal>();

        //Dodanie kota do listy:
        listaG.add(kot1);
        listaG.add(kot2);
        listaG.add(kot3);

        System.out.println("----------");
        for (Animal k : listaG) {
            System.out.println(k.imie);   //Rzutowanie na klasę Animal
        }
        System.out.println("----------");

        System.out.println((listaG.get(0)).imie);

        //ile mamy obiektów na liscie
        System.out.println(listaG.size()); //mamy 3 elementy na liście

        //sprawdzenie czy dany obiekt znajduje się już na liście, możemy wpisać nazwę lub jego indeks
        System.out.println(listaG.contains(kot1));
        System.out.println(listaG.contains(2));

        //Usuwanie elementów z listy:
        listaG.remove(kot1); //z podaniem nazwy obiektu
        listaG.remove(1); //z podaniem indeksu

        // po usunięciu mamy 1 obiekt na liście
        System.out.println(listaG.size());

        //Wyczyszczenie listy:
        listaG.clear();
        //Po wyczysczeniu nasza lista jest pusta
        System.out.println(listaG.size());


        //Wyświetlenie jeszcze raz elementów listy, by sprawdzić czy kot został usunięty
        System.out.println("----------");
        for (Animal k : listaG) {
            System.out.println(k.imie);   //Rzutowanie na klasę Animal
        }
        System.out.println("----------");
    }
}
