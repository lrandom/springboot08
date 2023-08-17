package niit.com.vn.springboot08.domains;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity(name = "products")
@Data
public class Product implements Serializable {
    @Id
    private Long id;


    private String title;
    private double price;
}
