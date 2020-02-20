import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Table(name = "Subscriptions")
public class Subscription {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    public Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    public Course course;
    @Column(name = "subscription_date")
    public Date subscriptionDate;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}
