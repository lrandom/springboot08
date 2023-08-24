package niit.com.vn.springboot08.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "shoes")
public class Shoes {
    @jakarta.persistence.Id
    private Long id;

    private String name;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    User user;

}
