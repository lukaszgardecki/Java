import java.util.ArrayDeque;
import java.util.Queue;

//        --------  KOLEJKA ---------

public class Kolejka {
    public static void main(String[] args) {
       //Kolejka
        Queue<String> kolejka = new ArrayDeque<>();

        kolejka.add("Pierwszy");
        kolejka.add("Drugi");
        kolejka.add("Trzeci");

        System.out.println(kolejka.size());

        //Przy zastosowaniu metody remove() z kolejki zostają wyrzucone elementyw  kolejności wejścia, tzn. napierw "Pierwszy", potem "Drugi", potem "Trzeci". Jezeli w kolejce już nie ma elementów to metoda wyrzuci błąd, tzn wyjątek.
        System.out.println(kolejka.remove());

        //Metoda peek() wyświetla aktualnie pierwszy element w kolejce
        System.out.println(kolejka.peek());


        //Drugią metodą kolejki do usuwania jest metoda poll(). Jeżeli w kolejce już nie ma elementów to metoda po prostu nie zadziała i zwróci wartość NULL
        System.out.println(kolejka.poll());

        System.out.println(kolejka.size());



    }
}
