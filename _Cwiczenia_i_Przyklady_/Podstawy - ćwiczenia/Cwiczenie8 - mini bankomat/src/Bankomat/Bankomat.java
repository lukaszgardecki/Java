package Bankomat;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bankomat {
    public static void main(String[] args) {
        Scanner sk = new Scanner(System.in);

        //Wyb�r:
        boolean dostep = false;
        String wybor = "";
        //Nr karty:
        String nrKarty = "";
        boolean kartaOK = false;
        //PIN:
        String nrPin = "";
        boolean pinOK = false;

        int nrKlienta = 0;

        double kwotaWyplaty;
        double kwotaWplaty;
        boolean saldoOK = true;

        ArrayList<Konto> baza = new ArrayList<Konto>();


        //Stworzenie kont:
        baza.add(new Konto("1005", "555", "8888", 150, "Zenek Martyniuk"));
        baza.add(new Konto("1006", "556","1234", 1750, "Karol Wojty�a"));
        baza.add(new Konto("1007", "557","9090", 790, "Pan Kleks"));


        System.out.println();
        System.out.println("------------ Witamy w banku! ------------");
        System.out.println( "[1] Wyp�a� �rodki \n" +
                            "[2] Wp�a� �rodki \n" +
                            "[3] Sprawd� stan konta");
        System.out.println("------------------------------------------");

        wybor = sk.nextLine();

        // Logowanie etap 0:
        while (dostep==false) {
            switch (wybor) {
                case "1", "2", "3":
                    dostep = true;
                    break;
                default:
                    System.out.println( "[1] Wyp�a� �rodki \n" +
                                        "[2] Wp�a� �rodki \n" +
                                        "[3] Sprawd� stan konta");
                    System.out.println("------------------------------------------");
                    System.out.println("Wprowad� [1], [2] lub [3]");
                    dostep = false;
                    wybor = sk.nextLine();
            }
        }


        // Logowanie etap 1:
        System.out.println("------------------------------------------");
        System.out.print("Wpisz numer karty: ");
        while (kartaOK==false) {
            nrKarty = sk.nextLine();

            for (int i = 0; i < baza.size(); i++) {
                if (baza.get(i).getNumerKarty().equals(nrKarty)) {
                    kartaOK = true;
                    nrKlienta = i;
                }

            }

            if (kartaOK) {
                System.out.print("Nr karty poprawny. Wpisz numer PIN: ");

            } else {
                System.out.print("Nr karty niepoprawny. Wpisz numer karty: ");
            }
        }


        // Logowanie etap 2:
        while (pinOK==false) {
            nrPin = sk.nextLine();

            if (baza.get(nrKlienta).getPIN().equals(nrPin)) {
                pinOK = true;
            }

            if (pinOK) {
                System.out.println("PIN poprawny");

            } else {
                System.out.print("PIN niepoprawny. Wpisz numer PIN: ");
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println("               Witaj " + baza.get(nrKlienta).getImieWlasciciela() + "!");
        System.out.print("Wyp�ata pieni�dzy. Wpisz kwot�: ");

        boolean war = true;
        String odp;



        // DO POPRAWY!!!

        while(war) {

                kwotaWyplaty = sk.nextDouble(); //=50


                //zr�b wyp�at�:
                baza.get(nrKlienta).wyplata(kwotaWyplaty);    //=1700
                double saldo = baza.get(nrKlienta).getSaldo();

                System.out.println("Wyp�acono " + kwotaWyplaty + " z�. Stan konta: " + saldo + " z�");
                System.out.println("[1] Wyp�a� ponownie     [2] Wyjd�");

                odp = sk.next();
                switch (odp) {
                    case "1" -> System.out.println("Wyp�ata pieni�dzy. Wpisz kwot�: ");
                    case "2" -> {
                        System.out.println("Dzi�kujemy i zapraszmy ponownie");
                        war = false;
                    }
                    default -> System.out.println("Wpisz poprawn� warto��");
                }
        }












    }
}
