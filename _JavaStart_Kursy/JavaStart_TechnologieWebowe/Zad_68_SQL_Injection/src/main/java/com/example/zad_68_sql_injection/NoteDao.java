package com.example.zad_68_sql_injection;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class NoteDao {
    private DataSource dataSource;

    NoteDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Dobrą praktyką jest używanie klasy PreparedStatement do wszystkich zapytań z parametrami, nawet wtedy, gdy parametry te nie pochodzą od użytkownika. Wykorzystanie tej klasy sprawia, że kod oprócz dodatkowej ochrony jest po prostu bardziej czytelny.
     * Jeżeli w Twoim zapytaniu SQL występują jakiekolwiek parametry, to w ich miejsce należy wstawić znaki zapytania. Następnie, korzystając z metod takich jak setString(), setInt(), setDouble() itd. możesz pod te znaki zapytania coś podstawić.
     */

    void save(Note note) {
        final String sql = "INSERT INTO notes (title, content, pass) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, note.getTitle());
            statement.setString(2, note.getContent());
            statement.setString(3, note.getPassword());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                note.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Optional<Note> findByTitleAndPassword(String title, String password) {
        final String sql = "SELECT id, title, content, pass FROM notes WHERE title=? AND pass=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, title);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int noteId = resultSet.getInt("id");
                String noteTitle = resultSet.getString("title");
                String noteContent = resultSet.getString("content");
                String notePassword = resultSet.getString("pass");
                return Optional.of(new Note(noteId, noteTitle, noteContent, notePassword));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
