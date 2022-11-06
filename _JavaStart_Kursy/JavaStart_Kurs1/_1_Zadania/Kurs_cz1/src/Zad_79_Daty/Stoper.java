package Zad_79_Daty;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

class Stoper {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Aby uruchomi� stoper, naci�nij ENTER:");
        scanner.nextLine();
        Instant now = Instant.now();

        System.out.println("ROZPOCZ�TO!");

        System.out.print("Aby zako�czy� stoper, naci�nij ENTER:");
        scanner.nextLine();
        Instant then = Instant.now();

        long sec = Duration.between(now, then).getSeconds() % 60;
        long min = Duration.between(now, then).getSeconds()/60 % 60;
        String m = min < 10 ? String.format("0%d", min) : String.format("%d", min);
        String s = sec < 10 ? String.format("0%d", sec) : String.format("%d", sec);

        System.out.printf("Czas: %s:%s\r", m, s);
    }
}
