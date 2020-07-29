package com.example.demo;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@Controller
public class HomePageController {

    @PostMapping("/time")
    @ResponseBody
    public ZonedDateTime time() {
        return ZonedDateTime.now();
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities());
        return "home";
    }

    @GetMapping("/logout")
    public String logoutg(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }
}
