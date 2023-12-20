package com.example.chapter1.controller;

import com.example.chapter1.domain.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @RequestMapping(value = "home")
    public String toLoginPage(Model model, @ModelAttribute UserData user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        List<String> usernames = new ArrayList<>();
        usernames.add("LiSa");
        usernames.add("Joey");
        usernames.add("Sam");
        model.addAttribute("user", user);
        model.addAttribute("usernames", usernames);
        model.addAttribute("pageTitle", "HomePage");
        return "home.html";
    }

    @GetMapping(value = "login")
    public String toLoginPage() {
        return "login.html";
    }

}