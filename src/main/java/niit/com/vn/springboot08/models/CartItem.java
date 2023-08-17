package niit.com.vn.springboot08.models;

import lombok.Data;
import niit.com.vn.springboot08.domains.Product;

import java.io.Serializable;

@Data
public class CartItem implements Serializable {
    private Product product;
    private int quantity = 0;

    public double getAmount() {
        return product.getPrice() * quantity;
    }
}
