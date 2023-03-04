package com.javarush.context.lesson9.controller;

import com.javarush.context.lesson9.command.LoginCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(LoginCommand loginCommand) {
        return "forward:/hello";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


}
