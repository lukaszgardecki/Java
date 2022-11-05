package Zad_80_Daty2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

class Zadanie {
    public static void main(String[] args) {

        LocalDate date1 = readDateFromUser();
        LocalDate date2 = readDateFromUser();

        showLaterDate(date1, date2);
        showPeriodBetween(date1, date2);
    }

    private static void showPeriodBetween(LocalDate date1, LocalDate date2) {
        Period period = Period.between(date1, date2);
        int days = Math.abs(period.getDays());
        int months = Math.abs(period.getMonths());
        int years = Math.abs(period.getYears());
        System.out.printf("Podane daty dzieli %d lat, %d miesiêcy i %d dni", years, months, days);
    }

    private static void showLaterDate(LocalDate date1, LocalDate date2) {
        LocalDate laterDate = date1.isBefore(date2) ? date2 : date1;
        System.out.println("PóŸniejsza data " + laterDate);
    }


    private static LocalDate readDateFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj dzieñ miesi¹ca");
        int day = scanner.nextInt();
        System.out.println("Podaj miesi¹c");
        int month = scanner.nextInt();
        System.out.println("Podaj rok");
        int year = scanner.nextInt();
        return LocalDate.of(year, month, day);
    }
}
