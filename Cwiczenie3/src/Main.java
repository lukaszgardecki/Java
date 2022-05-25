public class Main {


    //String przechowuje ciąg znaków
    // String jest typem złożonym

    public static void main(String[] args) {

        String sentence = "Mowa jest srebrem a milczenie złotem.";

        //gdy piszemy słowo "new" to jest tworzone nowe miejsce w pamięci operacyjnej, a gdy tego słowa nie ma to Java używa coś takiego jak pule stringów i nie towrzy nowego miejsca w pamięci
        String michal = "Michał";
        String name = "Michał";

        /*
            == porównanie miejsca w pamięci
            .equals porównanie wartości
         */

        //powinno zwrócić false, ale zwraca true
        System.out.println(michal==name);

        //equals porównuje miejsce w pamięci więc zwróci true
        System.out.println(name.equals(michal));

        //jeżeli utworzymy Stringa ze słowem new, to mówimy Javie żeby utworzyla nowe miejsce w pamięci operacyjnej i jednocześnie żeby nie stosowała otpymalizacji puli stringów
        String newString = new String("Michał");

        //Wynik false poneiważ jest nowe miejsce w pamięci operacyjnej
        System.out.println(name==newString);

        //Wynik true, ponieważ wartościowo są identyczne
        System.out.println(name.equals(newString));

        //zamieńmy sobie zmienną michał na duże litery
        System.out.println(name.toUpperCase());

        System.out.println(name);

        StringBuilder stringBuilder = new StringBuilder("Michał");
        //Odwrócenie stringa
        stringBuilder.reverse();
        System.out.println(stringBuilder);
        // usunięcie znaku ze stringa, np o indeksie 0, czyli pierwszą literę
        stringBuilder.deleteCharAt(0);
        System.out.println(stringBuilder);
        // dodanie znaku do stringa, wpisujemy numer indeksu i co dodajemy
        stringBuilder.insert(0,"M");
        System.out.println(stringBuilder);

    }
}
