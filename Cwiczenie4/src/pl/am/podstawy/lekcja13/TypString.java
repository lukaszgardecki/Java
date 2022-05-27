package pl.am.podstawy.lekcja13;

import java.util.Locale;

public class TypString {
    public static void main(String[] args) {
        System.out.println("Za��� g�l� ja��");
        System.out.println("cytat: \"b�dzie dobrze\"");
        System.out.println("\ttabulacja");
        System.out.println("ka�de \ns�owo \nw \nnowej \nlinii");
        String pi = "\u03C0"; // nie wy�wietla mi pi
        System.out.println(pi);

        String zdanie = "Ala ma kota";
        System.out.println(zdanie);

        // wy�wietl ci�g znak�w zaczynaj�c od 3 znaku. Liczenie zaczyna si� od zera:
        System.out.println(zdanie.substring(3));

        // wy�wietl ci�g znak�w zaczynaj�c od 3 znaku i ko�cz�c na 9 znaku. Dziewi�ty znak nie jest brany ju� pod uwag�.
        System.out.println(zdanie.substring(3,9));

        //metoda zwracaj�ca d�ugo�� �a�cucha:
        System.out.println(zdanie.length());

        //metoda wyszukuj�ca jaki� ci�g w innym ci�gu, zwraca indeks znaku pocz�tkowego szukanej frazy w oryginalnym zdaniu:
        System.out.println(zdanie.indexOf("ma"));

        //je�eli szukamy jakiego� �a�cucha w innym i wyszuka� jest wi�cej to metoda indexof zwr�ci tylko indeks pierwszego wyst�pienia
        System.out.println(zdanie.indexOf("a "));

        //je�eli szukamy jakiego� �a�cucha w innym i wyszuka� jest wi�cej to mo�emy r�wnie� zwr�ci� indeks OSTATNIEGO wyst�pinia:
        System.out.println(zdanie.lastIndexOf("a"));

        //zamiana ci�gu znak�w na ma�e litery:
        System.out.println("ma�e litery" + zdanie.toLowerCase());

        //zamiana ci�gu znak�w na du�e litery:
        System.out.println("wielkie litery" + zdanie.toUpperCase());

        //mo�emy r�wnie� srpawdzi� czy �a�cuch zaczyna si� od konkretnego �a�cucha znak�w, zwraca prawda fa�sz:
        System.out.println(zdanie.startsWith("Ala"));

        //mo�emy r�wnie� srpawdzi� czy �a�cuch zaczyna si� od konkretnego �a�cucha znak�w, zwraca prawda fa�sz:
        System.out.println(zdanie.startsWith("Ela"));

        //mo�emy r�wnie� sprawdzi� czy �a�cuch ko�czy si� konkretnym �a�cuchem znak�w, zwraca prawda fa�sz:
        System.out.println(zdanie.endsWith("kota"));

        //mo�emy r�wnie� sprawdzi� czy �a�cuch ko�czy si� konkretnym �a�cuchem znak�w, zwraca prawda fa�sz:
        System.out.println(zdanie.endsWith("psa"));

        //mo�emy r�wniez stringa podzieli� jakim� znakiem, tzn. je�eli w naszym stringu "Ala ma kota" wyst�puj� dwie spacje i my chcemy podzieli� tego stringa tymi spacjami, tzn. �e otrzymamy 3 r�wne s�owa: "Ala", "ma", "kota". Metoda zwr�ci ilo�� s��w kt�re otrzymali�my po podzieleniu:
        //Stw�rzmy tablic�, w kt�rej umie�cimy nasze s�owa i przypiszmy jej elementy w postaci pojedynczych s��w z naszego stringa:
        String[] tablicaStringow = zdanie.split(" ");
        System.out.println(tablicaStringow.length);

        //�eby si� upewni� czy nasz string zosta� rzeczywi�ciep podzielony, wy�wietlmy zawarto�� tablicy s�owo po s�owie:
        for (int i = 0; i < tablicaStringow.length; i++) {
            System.out.println(tablicaStringow[i]);
        }

        //metoda umo�liwiaj�ca po��cznie s��w za pomoc� jakiego� ci�gu. Np za pomoc� przecinka ze spacj� ", " po��czmy s�owa kot, pies, lama
        System.out.println(String.join(", ", "kot", "pies", "lama"));

        //mo�emy r�wnie� u�y� tej metody do po��czenia element�w talicy:
        System.out.println(String.join(", ", tablicaStringow));

        //metoda umo�liwiaj�c wy�wietlenie ze stringa znaku o konkretnym indeksie:
        System.out.println(zdanie.charAt(0)); //=A
        System.out.println(zdanie.charAt(7)); //=k

        //metoda umo�liwiaj�ca zamian� cz�ci ci�gu znak�w, innym ci�giem. Metoda ta analizuje wszystkie wyst�pienia danego ci�gu. Na przyk�ad w zdaniu "Ala ma kota" zmienimy s�owo "Ala" na "Weronika":
        System.out.println(zdanie.replace("Ala","Weronika"));
        //lub mo�emy zamieni� wszystkie ma�e literki "a" pustym znakiem:
        System.out.println(zdanie.replace("a", ""));

        //metoda czyszcz�ca stringa z bia�ych znak�w:
        System.out.println("      bia�e znaki          ".trim());

        //konkatenacja
        System.out.println("zdanie 1 " + "nie jest " + "zdaniem 2" );
        System.out.println(1 + 2 + " " + zdanie);
        System.out.println("1" + "1"); //=11
        System.out.println("1" + 1); //=11
        System.out.println(1 + "1"); //=11
        System.out.println("1" + 2 + 3); //=123

        //metoda por�wnuj�ca ci�gi znak�w:
        System.out.println("xd".equals("XD")); //=false
        System.out.println("xd".equalsIgnoreCase("XD")); //=true

    }
}
