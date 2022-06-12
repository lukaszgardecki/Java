package pl.lukasz.BazaProba;

import java.sql.SQLException;
import java.util.Optional;

public interface DatabaseQueries {

    void wstawKsiazke(String imieAutora, String nazwiskoAutora, String tytul, double cena) throws SQLException;

    Optional<Ksiazka> getKsiazka(String imieAutora);
}
