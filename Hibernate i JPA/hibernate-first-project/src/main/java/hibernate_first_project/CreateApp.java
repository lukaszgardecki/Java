package hibernate_first_project;

import hibernate_first_project.entity.Song;
import hibernate_first_project.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateApp {
    public static void main(String[] args) {

        //Tworzymy Session Factory (powinna być stworzona TYLKO jedna):
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(new Song("Jakaś piosenka", "Jakiś autor"));
        session.getTransaction().commit();
        session.close();
    }
}
