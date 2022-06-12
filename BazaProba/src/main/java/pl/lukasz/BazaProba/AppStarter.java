package pl.lukasz.BazaProba;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Optional;

public class AppStarter {
    public static void main(String[] args) {
        Database mysqlDatabase = new MysqlDatabase("localhost", 3306, "ksiegarnia", "root", "");
        mysqlDatabase.connect();

        DatabaseQueries queries = new MySqlDatabaseQueries(mysqlDatabase);

        //wstaw ksiazke:
        try {
            queries.wstawKsiazke("Zygmunt", "Kowalski", "Nad wielkim jeziorem macham jęzorem", 45.67);
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            System.out.println();
            System.err.println("coś poszło nie tak");
            System.out.println();
        }

        
/*        //wstaw ksiazke:
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
        pokazDaneKsiazki(queries, "Urządzenia techniki komputerowej");

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
