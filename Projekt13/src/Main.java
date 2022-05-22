import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

//      Kolekcja LinkedList jest szybsza

public class Main {
    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();
        lista.add("Poznań");
        lista.add("Warszawa");
        lista.remove(0);
        for (String e : lista) {
            System.out.println(e);
        }
        lista.clear();

// HashMapa jest kolekcją dwuelementową i przyjmuje wartości: klucz i wartość. W tym przypadku klucz będzie typu Integer a wartośc typu String
        HashMap<Integer,String> mapa = new HashMap<>();

        //Dodanie elementów, przed metodę put(), podobnie jak w listach było add()
        mapa.put(1, "Poniedzialek");
        mapa.put(2, "Wtorek");
        mapa.put(3, "Sroda");
        mapa.put(4, "Czwartek");
        mapa.put(5, "Piatek");
        mapa.put(6, "Sobota");
        mapa.put(7, "Niedziela");

        //Odwołując się do elementu mapy nie możemy podać indexu, bo elementy nie są numerowane tak jak w przypadku tablicy lub innych list od zera.Jeżeli chcemy się odwołać do elementu poprzez index musimy podać KLUCZ w tym przypadku liczba 1,2,3...
        System.out.println(mapa.get(5));

        //Pętla obiektowa dla mapy wyświetlająca wszystkie elementy. Nie możemy zostawić samo "mapa" tak jak w przypadku poprzednich list. Jeżeli chcemy się odwołać do wartości to po nazwie musimy dodać metodę values(), w przypadku gdybyśmy chcieli odwołać się do kluczy to możemy to zrobić przez dodanie metody keys().
        for (String e : mapa.values()) {
            System.out.println(e);
        }

        //Kolekcja HushSet - kolekcja typu generycznego. Na pierwszy rzut oka mamy to samo jak w ArrayList() - ale ta NIE PAMIĘTA KOLEJNOŚCI!!! Główna różnica jaka występuje między ArrayList() jest taka, żę ta kolekcja przechowuje wartości unikatowe, czyli jeżeli w naszej kolekcji znajdują się duplikaty to nie są one brane pod uwagę i nie są liczone przy wyświetlaniu liczby elementów listy.
        HashSet<String> zbior = new HashSet<>();
        zbior.add("Warszawa");
        zbior.add("Poznan");
        zbior.add("Szczecin");
        zbior.add("Szczecin");
        zbior.add("Szczecin");
        zbior.add("Szczecin");

        System.out.println();
        for (String e : zbior) {
            System.out.println(e);
        }

        //Kolekcja LinkedHushSet - kolekcja typu generycznego. Na pierwszy rzut oka mamy to samo jak w ArrayList() - ale ta pamięta kolejność!!! Główna różnica jaka występuje między ArrayList() jest taka, żę ta kolekcja przechowuje wartości unikatowe, czyli jeżeli w naszej kolekcji znajdują się duplikaty to nie są one brane pod uwagę i nie są liczone przy wyświetlaniu liczby elementów listy.
        LinkedHashSet<String> zbior1 = new LinkedHashSet<>();
        zbior1.add("Warszawa");
        zbior1.add("Poznan");
        zbior1.add("Szczecin");
        zbior1.add("Szczecin");
        zbior1.add("Szczecin");

        System.out.println();
        for (String e : zbior1) {
            System.out.println(e);
        }

    }
}
