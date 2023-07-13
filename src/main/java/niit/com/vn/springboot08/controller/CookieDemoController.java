package niit.com.vn.springboot08.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("cookieDemoController")
public class CookieDemoController {
    @GetMapping("/set-cookie")
    public String setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("username", "admin");
        cookie.setMaxAge(60 * 60 * 24 * 30);//30 ngày
        response.addCookie(cookie);
        return "set-cookie";
    }

    @GetMapping("/get-cookie")
    public String getCookie(@CookieValue(name = "username") String username, Model model){
        model.addAttribute("username", username);
        return "get-cookie";
    }

    @GetMapping("/delete-cookie")
    public String deleteCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);//trả về client
        return "set-cookie";
    }
}
