
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

    @EmbeddedId
    private SubscriptionId subscriptionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("studentId")
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @Embeddable
    public static class SubscriptionId implements Serializable{

        @JoinColumn(name = "student_id", nullable = true)
        private Integer studentId;

        @JoinColumn(name = "course_id")
        private Integer courseId;

        private Integer getStudentId() {
            return studentId;
        }

        public void setStudentId(Integer studentId) {
            this.studentId = studentId;
        }

        public Integer getCourseId() {
            return courseId;
        }

        public void setCourseId(Integer courseId) {
            this.courseId = courseId;
        }
    }

    public SubscriptionId getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(SubscriptionId subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

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