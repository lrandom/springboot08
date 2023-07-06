package niit.com.vn.springboot08.controller;

import niit.com.vn.springboot08.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("homeController")
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Nguyen Van A");
        model.addAttribute("age", 20);
        User user = new User();
        user.name = "Nguyen Van B";
        user.age = 30;
        model.addAttribute("user", user);
        model.addAttribute("weather", "sunny");

        String[] names = {"Nguyen Van C", "Nguyen Van D", "Nguyen Van E"};
        model.addAttribute("names", names);
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "test/about";
    }

/*    @PostMapping("/do-login")
    public String doLogin() {
        return "index";
    }

    // @GetMapping
    @RequestMapping(path = "/login",
            method = {RequestMethod.GET, RequestMethod.POST})
    public String login() {
        return "login";
    }*/
}
