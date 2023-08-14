package hibernate_first_project.utils;

import hibernate_first_project.entity.Song;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Zastosowano wzorzec SINGLETON

public class HibernateUtils {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {

        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Song.class);

                sessionFactory = configuration.buildSessionFactory();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nie utworzono połączenia z bazą danych.");
        }


        return sessionFactory;
    }
}
