package niit.com.vn.springboot08.services;

import jakarta.servlet.http.HttpSession;
import niit.com.vn.springboot08.domains.Product;
import niit.com.vn.springboot08.models.CartItem;
import niit.com.vn.springboot08.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService {
    private static final String CART = "cart";
    @Autowired
    private ProductRepository productRepository;

    public ArrayList<CartItem> getCartItems(HttpSession httpSession) {
        if (httpSession.getAttribute(CART) == null) {
            return null;
        }
        return (ArrayList<CartItem>) httpSession.getAttribute(CART);
    }

    public void addToCart(HttpSession httpSession, Long id) {

        Product product = productRepository.findById(id).get();

        //2 truong hop
        //case 1 : Chua co gio hang
        //case 2 : Co gio hang

        if (httpSession.getAttribute(CART) == null) {
            //chua co gio hang
            ArrayList<CartItem> cartItems = new ArrayList<>();
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cartItems.add(cartItem);
            httpSession.setAttribute(CART, cartItems);
        } else {
            //co gio hang
            //hai truong hop
            //co sp trong gio hang
            //chua co sp trong gio hang
            //lay nguoc lai cac san pham ra
            ArrayList<CartItem> cartItems = (ArrayList<CartItem>) httpSession.getAttribute(CART);
            boolean isExist = false;//bien co de check xem co sp trong gio hang chua
            for (CartItem cartItem : cartItems) {
                if (cartItem.getProduct().getId().equals(product.getId())) {
                    //co sp trong gio hang
                    cartItem.setQuantity(cartItem.getQuantity() + 1);//tang so luong len 1
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                //chua co sp trong gio hang
                CartItem cartItem = new CartItem();
                cartItem.setProduct(product);
                cartItem.setQuantity(1);
                cartItems.add(cartItem);
            }
            httpSession.setAttribute(CART, getCartItems(httpSession));
        }
    }

    public void emptyCart(HttpSession httpSession) {
        httpSession.removeAttribute(CART);
    }

    public void removeCartItem(Long id, HttpSession httpSession) {
        ArrayList<CartItem> cartItems = getCartItems(httpSession);
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId().equals(id)) {
                cartItems.remove(cartItem);
                break;
            }
        }
        httpSession.setAttribute(CART, cartItems);
    }

    public void updateQuantity(Long id, int quantity, HttpSession httpSession) {
        ArrayList<CartItem> cartItems = getCartItems(httpSession);
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId().equals(id)) {
                if (cartItem.getQuantity() + quantity == 0) {
                    cartItems.remove(cartItem);
                    break;
                }
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                break;
            }
        }
        httpSession.setAttribute(CART, cartItems);
    }
}
