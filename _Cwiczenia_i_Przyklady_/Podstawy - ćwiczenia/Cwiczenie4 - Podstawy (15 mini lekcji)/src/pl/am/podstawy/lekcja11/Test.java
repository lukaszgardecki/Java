package pl.am.podstawy.lekcja11;

import java.util.Scanner;

public class Test {
    static int iloscPunktow = 0;
    static int numerPytania = 1;


    //metoda zawierająca schemat pytania
    public static void zadajPytanie(String pytanie, String odpA, String odpB, String odpC, String odpD, String poprawnaOdpowiedz) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(numerPytania + ") " + pytanie);
        System.out.println("A) " + odpA);
        System.out.println("B) " + odpB);
        System.out.println("C) " + odpC);
        System.out.println("D) " + odpD);
        String odpowiedz = scanner.nextLine();

        numerPytania++;
        if (odpowiedz.equalsIgnoreCase(poprawnaOdpowiedz)) {
            iloscPunktow++;
        }


        System.out.println();
    }

    public static void wypiszTytul() {
        System.out.println();
        System.out.println(" /$$$$$$$$                    /$$                              /$$$$$                               \n" +
                "|__  $$__/                   | $$                             |__  $$                               \n" +
                "   | $$  /$$$$$$   /$$$$$$$ /$$$$$$         /$$$$$$$$            | $$  /$$$$$$  /$$    /$$ /$$   /$$\n" +
                "   | $$ /$$__  $$ /$$_____/|_  $$_/        |____ /$$/            | $$ |____  $$|  $$  /$$/| $$  | $$\n" +
                "   | $$| $$$$$$$$|  $$$$$$   | $$             /$$$$/        /$$  | $$  /$$$$$$$ \\  $$/$$/ | $$  | $$\n" +
                "   | $$| $$_____/ \\____  $$  | $$ /$$        /$$__/        | $$  | $$ /$$__  $$  \\  $$$/  | $$  | $$\n" +
                "   | $$|  $$$$$$$ /$$$$$$$/  |  $$$$/       /$$$$$$$$      |  $$$$$$/|  $$$$$$$   \\  $/   |  $$$$$$$\n" +
                "   |__/ \\_______/|_______/    \\___/        |________/       \\______/  \\_______/    \\_/     \\____  $$\n" +
                "                                                                                           /$$  | $$\n" +
                "                                                                                          |  $$$$$$/\n" +
                "                                                                                           \\______/ ");
        System.out.println();
    }

    public static void main(String[] args) {

        wypiszTytul();

        zadajPytanie("Jaka jest maksymalna liczba dla zmiennej typu byte?",
                "255","256","127","128","c");

        zadajPytanie("Ktory z podanych typow nie jest typem prostym?",
                "int","String","long","boolean","b");

        zadajPytanie("Ktora z podanych operacji ma NAJWYZSZY priorytet?",
                "przypisanie","odejmowanie","mnozenie","inkrementacja","d");

        zadajPytanie("Ktora z podanych operacji ma NAJNIZSZY priorytet?",
                "przypisanie","odejmowanie","mnozenie","inkrementacja","a");

        zadajPytanie("Na zmiennej ktorego z podanych typow mozemy zapisac najwieksza liczbe?",
                "byte","short","int","long","d");


        System.out.println("iloscPunktow = " + iloscPunktow);
    }
}
