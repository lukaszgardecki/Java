import java.util.Scanner;

public class Bankomat {
    /*
    Oprogramuj bankomat. Po włączeniu programu niech wyświetla komunikat włóż kartę. 3 dowolne litery oznaczają daną kartę, (zdefiniuj ją w kodzie programu, aby miała jakąś wartość konta) po wpisaniu ich przejdź do trybu wyboru, gdzie będą opcje wypłać pieniądze i stan konta. Pamiętaj, że użytkownik nie może wypłacić więcej niż ma, możemy uprościć i użytkownik może mieć tylko całe złotówki i wypłacić dowolną ilość (nie musi być wielokrotność 10). Pomyśl o programie w ten sposób, aby w razie czego móc utworzyć sieć bankomatów. Użytkownik może wypłacić pieniądze kilkukrotnie, dopóki ma pieniądze na koncie. UWAGA! Do porównywania tekstu nie używamy znaków == tylko metody „tekst”.equals(„tekst”) czyli string1.equals(string2) Dlaczego, opowiem w następnej lekcji, ale to bardzo ważna różnica.
     */
    public static void main(String[] args) {
        Scanner mojedane = new Scanner(System.in);
        boolean dostep = false;
        String haslo;
        String wybor = "0";
        int wyplata;
        int saldo; //być może trzeba zmienić typ


        //Tworzymy konto:
        Konto osoba1 = new Konto();
        osoba1.imie = "Lukasz";
        osoba1.karta = "xyz";
        osoba1.stan = 100;

//        //Tworzymy drugie konto:
//        Konto osoba2 = new Konto();
//        osoba2.imie = "Izabela";
//        osoba2.karta = "asdf";
//        osoba2.stan = 250;

        System.out.println("Wloz karte (wpisz 3 litery):");

        while (!dostep) {           //zanegowanie, czyli dopóki dostep==false
            haslo = mojedane.next();

            if (haslo.equals(osoba1.karta)) {
                dostep = true;
            } else {
                System.out.println("Haslo bledne. Sprobuj jeszcze raz.");

            }
        }

        if (dostep) {
            System.out.println("---------------ZLODZIEJ BANK SP.Z O.O---------------");
            System.out.println();
            System.out.println("       Witaj " + osoba1.imie + " na swoim koncie bankowym!");
            System.out.println();
            System.out.println("     Wyswietl stan konta                    [1]");
            System.out.println("     Wyplac srodki                          [2]");
            System.out.println();
            System.out.println("----------------------------------------------------");
        }


        while (wybor.equals("0")) {
            wybor = mojedane.nextLine();

            if (wybor.equals("1")) {
                System.out.println("Stan konta wynosi: " + osoba1.stan + " zl.");
                break;
            } else if (wybor.equals("2")) {
                System.out.println("Wpisz kwote: ");
                break;
            } else {
                System.out.println("Wpisz cyfry 1 lub 2. Sprobuj ponownie");
                //wybor = "0";

            }

        }
//        switch (wybor) {
//            case "2":
//                wyplata = mojedane.nextInt();
//                if (wyplata < osoba1.stan) {
//                    saldo = osoba1.stan - wyplata;
//                    System.out.println("Wyplacono " + wyplata + " zl. Na koncie pozostalo " + saldo + " zl.");
//                }
//
//
//
//        }


    }
}
