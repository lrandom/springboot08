package niit.com.vn.springboot08.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "users")
public class User {
    @Id
    private Long id;

    private String name;
    private int age;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private UserInfo userInfo;
}
