import java.util.ArrayList;

 //---------- LISTA NIEGENERYCZNA ----------
//.........lista jest kolekcją ---------

public class Lista1 {
    public static void main(String[] args) {
        Animal kot1 = new Animal("Rudy");
        Animal kot2 = new Animal("Bury");
        Animal kot3 = new Animal("Bialy");

        //Tworzymy listę, nie podajemy w nawiasie rozmiaru listy bo ona domyślanie ma 0 elemetów
        ArrayList lista = new ArrayList();

        //Dodanie kota do listy:
        lista.add(kot1);
        lista.add(kot2);
        lista.add(kot3);

        System.out.println("----------");
        for (Object k : lista) {
            System.out.println(((Animal)k).imie);   //Rzutowanie na klasę Animal
        }
        System.out.println("----------");

        System.out.println(((Animal)lista.get(0)).imie);

        //ile mamy obiektów na liscie
        System.out.println(lista.size()); //mamy 3 elementy na liście

        //sprawdzenie czy dany obiekt znajduje się już na liście, możemy wpisać nazwę lub jego indeks
        System.out.println(lista.contains(kot1));
        System.out.println(lista.contains(2));

        //Usuwanie elementów z listy:
        lista.remove(kot1); //z podaniem nazwy obiektu
        lista.remove(1); //z podaniem indeksu

        // po usunięciu mamy 1 obiekt na liście
        System.out.println(lista.size());

        //Wyczyszczenie listy:
        lista.clear();
        //Po wyczysczeniu nasza lista jest pusta
        System.out.println(lista.size());


        //Wyświetlenie jeszcze raz elementów listy, by sprawdzić czy kot został usunięty
        System.out.println("----------");
        for (Object k : lista) {
            System.out.println(((Animal)k).imie);   //Rzutowanie na klasę Animal
        }
        System.out.println("----------");
    }
}
