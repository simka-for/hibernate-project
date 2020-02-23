import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LinkedPurchaseList")
@IdClass(LinkedPurchaseList.LinkedPurchaseListId.class)
public class LinkedPurchaseList implements Serializable{

    @Id
    @Column(name = "student_id", nullable = false)
    Integer studentId;

    @Id
    @Column(name = "course_id", nullable = false)
    Integer courseId;

    @Column(name = "price", nullable = false)
    Integer  price;

    @ManyToOne
    @MapsId("courseId")
    private Course course;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @Column(name = "subscription_date", nullable = false)
    private Date subscriptionDate;

    @Embeddable
    public static class LinkedPurchaseListId implements Serializable {

        Integer studentId;
        Integer courseId;

        public Integer getStudentId() {
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

    public Integer getStudentId() {
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
