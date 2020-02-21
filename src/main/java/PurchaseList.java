import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Purchaselist")
public class PurchaseList {

    @EmbeddedId
    private PurchaseListId purchaseListId;

    private int price;

    @Column(name = "subscription_date")
    public Date subscriptionDate;

    @Embeddable
    public class PurchaseListId implements Serializable {

        @ManyToOne
        @JoinColumn(name = "student_name")
        private Student student;

        @ManyToOne
        @JoinColumn(name = "course_name")
        private Course course;
    }
}