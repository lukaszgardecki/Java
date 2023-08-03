package pl.lukasz.BazaProba;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class AppStarter {
    public static void main(String[] args) {
        Database mysqlDatabase = new MysqlDatabase("localhost", 3306, "ksiegarnia", "root", "");
        mysqlDatabase.connect();

        DatabaseQueries queries = new MySqlDatabaseQueries(mysqlDatabase);

        //wstaw ksiazke przy użyciu skanera:
        try {
            Scanner sk = new Scanner(System.in);

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---Wstawianie książki do bazy---");
            System.out.println("Podaj imię autora: ");
            String imie = sk.nextLine();

            System.out.println("Podaj nazwisko autora: ");
            String nazwisko = sk.nextLine();

            System.out.println("Podaj tytuł książki:  ");
            String ty = sk.nextLine();

            System.out.println("Podaj cenę książki: ");
            double cn = sk.nextDouble();

            //wstawianie książi
            queries.wstawKsiazke(imie, nazwisko, ty, cn);
            //komunikat, że wstawiono książkę:
            System.out.println("Pomyślnie dodano książkę do bazy danych.");
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            System.out.println();
            System.err.println("Coś poszło nie tak");
            System.out.println();
        }


/*        //wstaw ksiazke na sztywno z bazy:
        try {
            queries.wstawKsiazke("Zygmunt", "Kowalski", "Nad wielkim jeziorem macham jęzorem", 45.67);
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            System.out.println();
            System.err.println("coś poszło nie tak");
            System.out.println();
        }
*/

        //pobierz dane o ksiazce z bazy:
        //pokazDaneKsiazki(queries, "Urządzenia techniki komputerowej");

        //rozłącz połączenie z bazą danych
        mysqlDatabase.disconnect();
    }




    private static void pokazDaneKsiazki(DatabaseQueries queries, String tytul) {
        Optional<Ksiazka> optionalKsiazka = queries.getKsiazka(tytul);

        boolean present = optionalKsiazka.isPresent();
        optionalKsiazka.ifPresent(
                x -> System.out.println(x.getTytul() + ", cena " + x.getCena()));
        if (!present) {
            System.out.println("Nie znaleziono ksiązki o tytule " + tytul);
        }
    }
}
