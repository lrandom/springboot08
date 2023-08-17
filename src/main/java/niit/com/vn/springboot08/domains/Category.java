package niit.com.vn.springboot08.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;


    private String name;
}
