package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
    public static void main(String[] args) throws SQLException {

        //Stworzenie po��czenia (w taki spos�b. na ko�cu jest nazwa bazy danych)
        String url = "jdbc:postgresql://localhost/test";
        Connection conn = null;

        // elementy kt�re b�dziemy umieszcza� w bazie danych
        int rollno = 2;
        String name = "Jane";
        int age = 22;

        // nasze zapytanie do bazy danych, kt�re umie�ci dane w bazie
        String sql = "insert into student(rollno, name, age) "
                + "values(" + rollno + ",'" + name + "'," + age + ")";

        try {
            /**
             *  �eby si� po��czy� z baz� danych musimy tak to zrobi�
             *  podajemy adres, nazw� u�ytkownika i has�o
             *  ta linijka ni�ej sprawia �e mamy po��czenie z baz� danych
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
            //  bardzo wa�ne! trzeba zamkn�� po��czenie z baz� danych
            conn.close();
        }

    }
}
