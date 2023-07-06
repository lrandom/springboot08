package niit.com.vn.springboot08.controller;

import niit.com.vn.springboot08.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("userController")
public class UserController {
    @GetMapping("/user/add")
    public String add(Model model) {
        User user = new User();
        user.setName("Nguyễn Thành Luân");
        model.addAttribute("user", user);
        return "user/add";
    }

    @PostMapping("/user/save")
    public void save(User user) {
        System.out.println("Name: " + user.name);
        System.out.println("Address: " + user.address);
        System.out.println("Age: " + user.age);
    }
}
