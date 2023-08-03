package hibernate_first_project;

import hibernate_first_project.entity.Song;
import hibernate_first_project.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadApp {
    public static void main(String[] args) {

        //Tworzymy Session Factory (powinna być stworzona TYLKO jedna):
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();

        Song song = session.get(Song.class, 1);
        System.out.println(song);

        session.close();
    }
}
