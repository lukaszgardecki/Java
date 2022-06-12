package pl.lukasz.BazaProba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MySqlDatabaseQueries implements DatabaseQueries {

    private final Database database;

    public MySqlDatabaseQueries(Database database) {
        this.database = database;
    }


    @Override
    public void wstawKsiazke(String imieAutora, String nazwiskoAutora, String tytul, double cena) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ksiazki (imieautora, nazwiskoautora, tytul, cena) VALUES (?, ?, ?, ?)");
        preparedStatement.setString(1, imieAutora);
        preparedStatement.setString(2, nazwiskoAutora);
        preparedStatement.setString(3, tytul);
        preparedStatement.setDouble(4, cena);
        preparedStatement.execute();
        preparedStatement.clearParameters();
        preparedStatement.close();

    }



    @Override
    public Optional<Ksiazka> getKsiazka(String tytul) {
        try {
            Connection connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ksiazki WHERE tytul=?");
            preparedStatement.setString(1, tytul);
            ResultSet resultSet = preparedStatement.executeQuery();

            boolean next = resultSet.next();

            if (!next) {                //jezeli wartości nie ma
                return Optional.empty();    // to powiedz że nic nie ma
            }


           //jeżeli natomiast jest to zwróće ci nowy obiekt Książka
            return Optional.of(new Ksiazka(
                    resultSet.getString("imieautora"),
                    resultSet.getString("nazwiskoautora"),
                    resultSet.getString("tytul"),
                    resultSet.getDouble("cena")
            ));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //jeżeli wystąpi błąd to wzóć pusty obiekt...nie jest to najlepszy sposób, może to doproowadzić do jakichś błędów
            return Optional.empty();
        }


    }
}
