package pl.lukasz.BazaProba;

import java.sql.Connection;
import java.sql.SQLException;

//ten interfejs jest pdpowiedizalny za łączenie i rozłączenie z naszą bazą danych

public interface Database {

    void connect();
    void disconnect();

    Connection getConnection() throws SQLException;
}
