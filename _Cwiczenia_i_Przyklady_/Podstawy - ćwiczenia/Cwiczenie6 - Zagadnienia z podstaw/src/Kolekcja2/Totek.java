package Kolekcja2;

import java.util.ArrayList;
import java.util.Random;

public class Totek {

    //Tworzymy metod� publiczn�, statyczn�, kt�ra b�dzie odpowiedzialna za losowanie
    public static int[] losuj(int k, int n) {
        //zmienna "crazy" b�dzie przechowywa� liczb� randomow�:
        Random crazy = new Random();

        /*
        Stw�rz list�:
            - zawieraj�c� dane typu String
            - o nazwie "pula"
            - zawieraj�c� n element�w
         */
        ArrayList<Integer> pula = new ArrayList<>(n);

        /*
        Stw�rz tablic�:
            - zawieraj�c� dane typu int,
            - o nazwie "wylosowane"
            - zawieraj�c� k element�w
         */

        int[] wylosowane = new int[k];

        //dodaj n element�w do listy pula: (czyli tyle element�w ile definiujemy na pocz�tku �e ich b�dzie). Czyli je�eli losowanie ma odby� si� spo�r�d 50 liczb to stw�rz 50 element�w listy pula:
        for (int i = 1; i <= n; i++) {
            pula.add(i);
        }

        //przypisz liczb� element�w n (np. 50) do nowej zmiennej "counter":
        int counter = n;

        /*
        Przy u�yciu p�tli for, wykonaj k losowa�
        wylosowan� liczb� od 1 do 50 przypisz zmiennej o nazwie "index"
        z listy "pula" pobierz liczb� pod zmienn� index i przypisz indeksom tablicy "wylosowane"
        Usu� liczb� pod zmienn� index z listy "pula"
        Z ka�dym wykonaniem p�tli dekrementuj "counter" (counter--):
         */
        for (int j = 0; j < k; j++) {
            int index = crazy.nextInt(counter);
            wylosowane[j] = pula.get(index);
            pula.remove(index);
            counter--;
        }
        //metoda jest tablicowa, wi�c zwraca tablic�:
        return wylosowane;
    }
}
