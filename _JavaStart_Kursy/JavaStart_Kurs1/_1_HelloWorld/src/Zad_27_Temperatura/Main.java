package Zad_27_Temperatura;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj temperatur� aktualn�:");
        double temp1 = scanner.nextInt();

        System.out.println("Podaj temperatur� docelow�:");
        double temp2 = scanner.nextInt();

        while (temp1 != temp2) {
            if (temp1 > temp2) {
                System.out.println("Aktualna temperatura: " + temp1);
                temp1 -= 0.5;
            } else {
                System.out.println("Aktualna temperatura: " + temp1);
                temp1 += 0.5;
            }
        }
        System.out.println("Osi�gni�to temperatur� docelow� " + temp2 + " stopni");
    }
}
