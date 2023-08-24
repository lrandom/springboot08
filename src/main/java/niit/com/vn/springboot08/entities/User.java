package niit.com.vn.springboot08.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity(name = "users")
public class User {
    @Id
    private Long id;

    private String name;
    private int age;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private UserInfo userInfo;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<Shoes> shoes;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Collection<Subject> subjects;
}
