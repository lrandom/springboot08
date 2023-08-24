package niit.com.vn.springboot08.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Collection;

@Data
@Entity(name = "subjects")
public class Subject {
    @jakarta.persistence.Id
    private Long id;

    private String name;

    @ManyToMany()
    @JoinTable(name = "user_subjects", joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    Collection<User> users;
}
