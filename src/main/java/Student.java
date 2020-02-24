import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Students")
@Data
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int age;
    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> courseList;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<PurchaseList> purchaseLists;

}
