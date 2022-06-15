package pl.lukasz.BazaProba;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlDatabase implements Database {

    private String host, user, password, db;
    private int port;
    private HikariDataSource hikari;     //czemu Hikari?
    //biblioteka hikari cp, która jest odpowiedizalna za sterowanie połączeniami do różńych baz danych


    private MysqlDatabase() {

    }

    //tworzymy konstruktor przyjmujący parametry
    public MysqlDatabase(String host, int port, String db, String user, String password) {
        this.host = host;
        this.port = port;
        this.db = db;
        this.user = user;
        this.password = password;
    }


    @Override
    public void connect() {
        hikari = new HikariDataSource();
        hikari.setDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");
        hikari.addDataSourceProperty("serverName", host);
        hikari.addDataSourceProperty("port", port);
        hikari.addDataSourceProperty("databaseName", db);
        hikari.addDataSourceProperty("user", user);
        hikari.addDataSourceProperty("password", password);

    }

    @Override
    public void disconnect() {
        hikari.close();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return hikari.getConnection();
        //jeżeli już się połączyliśmy z bazą danych to chcielibyśmy wykorzystać aktywne połączenia aby wykonać pewne operacje
    }
}
