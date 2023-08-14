package hibernate_first_project;

import hibernate_first_project.entity.Song;
import hibernate_first_project.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteApp {
    public static void main(String[] args) {

        // Tworzymy konfigurację (wskazując plik z konfiguracją hibernate):
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Song song = session.get(Song.class, 1);
        session.remove(song);
        session.getTransaction().commit();
        session.close();
    }


}
