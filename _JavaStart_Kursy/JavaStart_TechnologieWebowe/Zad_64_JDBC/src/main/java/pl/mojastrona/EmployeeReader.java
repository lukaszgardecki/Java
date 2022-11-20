package pl.mojastrona;

import java.sql.*;

public class EmployeeReader {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String password = "admin";


        // Po zakończeniu pracy z obiektami Connection, Statement i ResultSet, powinniśmy je zamknąć i zwolnić związane z nimi zasoby. dzięki użyciu bloku try with resources nie musimy zamykać ręcznie połączenia z bazą
        try (
                Connection connection = DriverManager.getConnection(url, user, password);

                //Obiekt reprezentujący zapytanie do bazy:
                Statement statement = connection.createStatement();

                //Zapytania typu Select:
                ResultSet resultSet = statement.executeQuery("SELECT first_name, last_name, hire_date FROM employees LIMIT 10");
        ) {
            //Wyświetlenie wszystkich rekordów z wynikowego zbioru:
            while (resultSet.next()) {
//            String firstName = resultSet.getString(1); // można również po indeksie kolumny liczonym od 1
                String firstName = resultSet.getString("first_name");
//            String lastName = resultSet.getString(2);
                String lastName = resultSet.getString("last_name");
//            Date hireDate = resultSet.getDate(3);
                Date hireDate = resultSet.getDate("hire_date");
                System.out.printf("%s %s - data zatrudnienia: %s\n", firstName, lastName, hireDate.toString());
            }
        }








    }
}
