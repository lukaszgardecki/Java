package Kolekcja2;

import java.util.ArrayList;
import java.util.Random;

public class Totek {

    //Tworzymy metodê publiczn¹, statyczn¹, która bêdzie odpowiedzialna za losowanie
    public static int[] losuj(int k, int n) {
        //zmienna "crazy" bêdzie przechowywaæ liczbê randomow¹:
        Random crazy = new Random();

        /*
        Stwórz listê:
            - zawieraj¹c¹ dane typu String
            - o nazwie "pula"
            - zawieraj¹c¹ n elementów
         */
        ArrayList<Integer> pula = new ArrayList<>(n);

        /*
        Stwórz tablicê:
            - zawieraj¹c¹ dane typu int,
            - o nazwie "wylosowane"
            - zawieraj¹c¹ k elementów
         */

        int[] wylosowane = new int[k];

        //dodaj n elementów do listy pula: (czyli tyle elementów ile definiujemy na pocz¹tku ¿e ich bêdzie). Czyli je¿eli losowanie ma odbyæ siê spoœród 50 liczb to stwórz 50 elementów listy pula:
        for (int i = 1; i <= n; i++) {
            pula.add(i);
        }

        //przypisz liczbê elementów n (np. 50) do nowej zmiennej "counter":
        int counter = n;

        /*
        Przy u¿yciu pêtli for, wykonaj k losowañ
        wylosowan¹ liczbê od 1 do 50 przypisz zmiennej o nazwie "index"
        z listy "pula" pobierz liczbê pod zmienn¹ index i przypisz indeksom tablicy "wylosowane"
        Usuñ liczbê pod zmienn¹ index z listy "pula"
        Z ka¿dym wykonaniem pêtli dekrementuj "counter" (counter--):
         */
        for (int j = 0; j < k; j++) {
            int index = crazy.nextInt(counter);
            wylosowane[j] = pula.get(index);
            pula.remove(index);
            counter--;
        }
        //metoda jest tablicowa, wiêc zwraca tablicê:
        return wylosowane;
    }
}
