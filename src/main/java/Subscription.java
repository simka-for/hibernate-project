import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

    @EmbeddedId
    private SubscriptionId subscriptionId;

    @Column(name = "subscription_date")
    public Date subscriptionDate;

    @Embeddable
    public class SubscriptionId implements Serializable{

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "student_id")
        public Student student;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "course_id")
        public Course course;
    }

}