package niit.com.vn.springboot08.controller;

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
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "test/about";
    }

    @PostMapping("/do-login")
    public String doLogin() {
        return "index";
    }
    // @GetMapping
    @RequestMapping(path = "/login",
            method = { RequestMethod.GET, RequestMethod.POST })
    public String login() {
        return "login";
    }
}
