package com.example.zad_67_ksiegagosci;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VisitDao {
    private final DataSource dataSource;

    public VisitDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    List<Visit> findAll() {
        final String sql = "SELECT id, name, text FROM guests ORDER BY id DESC";
        List<Visit> visitList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String author = resultSet.getString("name");
                String text = resultSet.getString("text");
                visitList.add(new Visit(id, author, text));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return visitList;
    }

    void add(Visit visit) {
        final String sql = String.format("INSERT INTO guests (name, text) VALUES ('%s', '%s')", visit.getAuthor(), visit.getText());

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
