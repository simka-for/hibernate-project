import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Teachers")
@Data
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int salary;
    private int age;

    @OneToMany(mappedBy = "teacher")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Course> courses;

}
