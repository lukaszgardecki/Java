package hibernate_first_project;

import hibernate_first_project.entity.Song;
import hibernate_first_project.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateApp {
    public static void main(String[] args) {

        //Tworzymy Session Factory (powinna być stworzona TYLKO jedna):
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();

        // Otwieramy transakcję i zmieniamy interesujące nas pole:
        session.beginTransaction();
        Song song = session.get(Song.class, 1);
        song.setArtist("tralalal");
        session.getTransaction().commit();
        session.close();
    }
}
