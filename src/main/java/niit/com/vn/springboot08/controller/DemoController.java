package niit.com.vn.springboot08.controller;

import niit.com.vn.springboot08.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("DemoController")
public class DemoController {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/demo-1-1")
    public String index() {
        userRepository.findById(Long.parseLong("1")).ifPresent(user -> {
            System.out.println(user.getName());
            System.out.println(user.getUserInfo().getAddress());
            System.out.println(user.getUserInfo().getPhone());
        });
        return "index";
    }
}
