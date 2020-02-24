import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
@Data
public class Subscription implements Serializable{

    @EmbeddedId
    private SubscriptionId subscriptionId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @Embeddable
    @Data
    public static class SubscriptionId implements Serializable{

        @JoinColumn(name = "student_id", nullable = true)
        private Integer studentId;

        @JoinColumn(name = "course_id")
        private Integer courseId;


    }

}