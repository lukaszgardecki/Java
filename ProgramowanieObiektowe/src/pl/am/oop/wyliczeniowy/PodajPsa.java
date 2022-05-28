package pl.am.oop.wyliczeniowy;

import java.util.Arrays;
import java.util.Scanner;

public class PodajPsa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jak siê twój pies wabi? ");
        String nazwa = scanner.nextLine();

        System.out.println("Podaj mase psa: ");
        double masa = Double.parseDouble(scanner.nextLine());

        System.out.println("Podaj rase paa (" + Arrays.toString(Rasa.values()) + ")");
        String rasaString = scanner.nextLine().toUpperCase();
        //Rasa rasa = Enum.valueOf(Rasa.class, rasaString);
        Rasa rasa = Rasa.valueOf(rasaString);

        Pies pies = new Pies(nazwa, rasa, masa);

        System.out.println(pies);
    }
}
