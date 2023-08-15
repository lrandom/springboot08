package niit.com.vn.springboot08.controller;

import niit.com.vn.springboot08.entities.Product;
import niit.com.vn.springboot08.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;

@Controller(value = "HomeController")
public class HomeController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/list-product")
    public String list(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "list-product";
    }
}
