package pl.am.podstawy.lekcja13;

import java.util.Locale;

public class TypString {
    public static void main(String[] args) {
        System.out.println("Za¿ó³æ gêœl¹ jaŸñ");
        System.out.println("cytat: \"bêdzie dobrze\"");
        System.out.println("\ttabulacja");
        System.out.println("ka¿de \ns³owo \nw \nnowej \nlinii");
        String pi = "\u03C0"; // nie wyœwietla mi pi
        System.out.println(pi);

        String zdanie = "Ala ma kota";
        System.out.println(zdanie);

        // wyœwietl ci¹g znaków zaczynaj¹c od 3 znaku. Liczenie zaczyna siê od zera:
        System.out.println(zdanie.substring(3));

        // wyœwietl ci¹g znaków zaczynaj¹c od 3 znaku i koñcz¹c na 9 znaku. Dziewi¹ty znak nie jest brany ju¿ pod uwagê.
        System.out.println(zdanie.substring(3,9));

        //metoda zwracaj¹ca d³ugoœæ ³añcucha:
        System.out.println(zdanie.length());

        //metoda wyszukuj¹ca jakiœ ci¹g w innym ci¹gu, zwraca indeks znaku pocz¹tkowego szukanej frazy w oryginalnym zdaniu:
        System.out.println(zdanie.indexOf("ma"));

        //je¿eli szukamy jakiegoœ ³añcucha w innym i wyszukañ jest wiêcej to metoda indexof zwróci tylko indeks pierwszego wyst¹pienia
        System.out.println(zdanie.indexOf("a "));

        //je¿eli szukamy jakiegoœ ³añcucha w innym i wyszukañ jest wiêcej to mo¿emy równie¿ zwróciæ indeks OSTATNIEGO wyst¹pinia:
        System.out.println(zdanie.lastIndexOf("a"));

        //zamiana ci¹gu znaków na ma³e litery:
        System.out.println("ma³e litery" + zdanie.toLowerCase());

        //zamiana ci¹gu znaków na du¿e litery:
        System.out.println("wielkie litery" + zdanie.toUpperCase());

        //mo¿emy równie¿ srpawdziæ czy ³añcuch zaczyna siê od konkretnego ³añcucha znaków, zwraca prawda fa³sz:
        System.out.println(zdanie.startsWith("Ala"));

        //mo¿emy równie¿ srpawdziæ czy ³añcuch zaczyna siê od konkretnego ³añcucha znaków, zwraca prawda fa³sz:
        System.out.println(zdanie.startsWith("Ela"));

        //mo¿emy równie¿ sprawdziæ czy ³añcuch koñczy siê konkretnym ³añcuchem znaków, zwraca prawda fa³sz:
        System.out.println(zdanie.endsWith("kota"));

        //mo¿emy równie¿ sprawdziæ czy ³añcuch koñczy siê konkretnym ³añcuchem znaków, zwraca prawda fa³sz:
        System.out.println(zdanie.endsWith("psa"));

        //mo¿emy równiez stringa podzieliæ jakimœ znakiem, tzn. je¿eli w naszym stringu "Ala ma kota" wystêpuj¹ dwie spacje i my chcemy podzieliæ tego stringa tymi spacjami, tzn. ¿e otrzymamy 3 równe s³owa: "Ala", "ma", "kota". Metoda zwróci iloœæ s³ów które otrzymaliœmy po podzieleniu:
        //Stwórzmy tablicê, w której umieœcimy nasze s³owa i przypiszmy jej elementy w postaci pojedynczych s³ów z naszego stringa:
        String[] tablicaStringow = zdanie.split(" ");
        System.out.println(tablicaStringow.length);

        //¿eby siê upewniæ czy nasz string zosta³ rzeczywiœciep podzielony, wyœwietlmy zawartoœæ tablicy s³owo po s³owie:
        for (int i = 0; i < tablicaStringow.length; i++) {
            System.out.println(tablicaStringow[i]);
        }

        //metoda umo¿liwiaj¹ca po³¹cznie s³ów za pomoc¹ jakiegoœ ci¹gu. Np za pomoc¹ przecinka ze spacj¹ ", " po³¹czmy s³owa kot, pies, lama
        System.out.println(String.join(", ", "kot", "pies", "lama"));

        //mo¿emy równie¿ u¿yæ tej metody do po³¹czenia elementów talicy:
        System.out.println(String.join(", ", tablicaStringow));

        //metoda umo¿liwiaj¹c wyœwietlenie ze stringa znaku o konkretnym indeksie:
        System.out.println(zdanie.charAt(0)); //=A
        System.out.println(zdanie.charAt(7)); //=k

        //metoda umo¿liwiaj¹ca zamianê czêœci ci¹gu znaków, innym ci¹giem. Metoda ta analizuje wszystkie wyst¹pienia danego ci¹gu. Na przyk³ad w zdaniu "Ala ma kota" zmienimy s³owo "Ala" na "Weronika":
        System.out.println(zdanie.replace("Ala","Weronika"));
        //lub mo¿emy zamieniæ wszystkie ma³e literki "a" pustym znakiem:
        System.out.println(zdanie.replace("a", ""));

        //metoda czyszcz¹ca stringa z bia³ych znaków:
        System.out.println("      bia³e znaki          ".trim());

        //konkatenacja
        System.out.println("zdanie 1 " + "nie jest " + "zdaniem 2" );
        System.out.println(1 + 2 + " " + zdanie);
        System.out.println("1" + "1"); //=11
        System.out.println("1" + 1); //=11
        System.out.println(1 + "1"); //=11
        System.out.println("1" + 2 + 3); //=123

        //metoda porównuj¹ca ci¹gi znaków:
        System.out.println("xd".equals("XD")); //=false
        System.out.println("xd".equalsIgnoreCase("XD")); //=true

    }
}
