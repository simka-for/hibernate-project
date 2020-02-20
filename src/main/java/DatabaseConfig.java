import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DatabaseConfig {

    public static void init(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Subscription sub = new Subscription();
//        Course course = session.get(Course.class, 3);
//        Student im = new Student("Серафим Обрезумов", 21);
//        Date date = new Date();
//
//        sub.setCourse(course);
//        sub.setStudent(im);
//        sub.setSubscriptionDate(date);
//
//        session.save(sub);

        // = =====================================

//        Teacher teacher = session.get(Teacher.class, 1);
//        List<Course> coursesOnTeacher = teacher.getCourses();
//        coursesOnTeacher.forEach( course -> course.getDuration());

        Student student = session.get(Student.class, 30);
        List<Course> courses = student.getCourseList();
        courses.forEach(course -> course.getTeacher().getName());


        transaction.commit();
        sessionFactory.close();
    }
}