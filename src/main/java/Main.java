import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {

        //remove info logs to console for hibernate
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        Course course = session.get(Course.class, 2);

        System.out.println(course.getName() + " - " + course.getPrice() + " руб");
        course.students.stream().map(s-> s.getName() + " " + s.getAge()).forEach(System.out::println);


        List<PurchaseList> purchaseLists = session.createCriteria(PurchaseList.class).setMaxResults(5).list();
        purchaseLists.forEach(System.out::println);
        System.out.println(purchaseLists.get(1).getStudent().getName());

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
