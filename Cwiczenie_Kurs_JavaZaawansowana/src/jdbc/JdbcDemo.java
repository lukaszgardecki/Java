package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
    public static void main(String[] args) throws SQLException {

        //Stworzenie po³¹czenia (w taki sposób. na koñcu jest nazwa bazy danych)
        String url = "jdbc:postgresql://localhost/test";
        Connection conn = null;

        // elementy które bêdziemy umieszczaæ w bazie danych
        int rollno = 2;
        String name = "Jane";
        int age = 22;

        // nasze zapytanie do bazy danych, które umieœci dane w bazie
        String sql = "insert into student(rollno, name, age) "
                + "values(" + rollno + ",'" + name + "'," + age + ")";

        try {
            /**
             *  ¿eby siê po³¹czyæ z baz¹ danych musimy tak to zrobiæ
             *  podajemy adres, nazwê u¿ytkownika i has³o
             *  ta linijka ni¿ej sprawia ¿e mamy po³¹czenie z baz¹ danych
             */

            conn = DriverManager.getConnection(url, "postgres", "password");

            Statement st = conn.createStatement();
            int m = st.executeUpdate(sql);
            if (m == 1) {
                System.out.println("inserted successfully : " + sql);
            } else {
                System.err.println("insertion failed");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            //  bardzo wa¿ne! trzeba zamkn¹æ po³¹czenie z baz¹ danych
            conn.close();
        }

    }
}
