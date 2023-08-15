package niit.com.vn.springboot08.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "products")
@Data
public class Product {
    @Id
    private String id;


    private String title;
    private double price;
}
