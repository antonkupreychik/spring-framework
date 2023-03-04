package com.javarush.context.lesson9.controller;

import com.javarush.context.lesson5.service.UserService;
import com.javarush.context.lesson9.command.UserCreateCommand;
import com.javarush.context.lesson9.command.UserUpdateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    //private final UserService userService;

    @GetMapping
    public String findAll(Model model) {
        //model.setAttributes("users", userService.findAll())
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable Long id) {
        //model.setAttribute("user", userService.findById(id);
        return "user/user";
    }

    @PostMapping
    public String create(@ModelAttribute UserCreateCommand userCreateCommand) {
        //userService.create(userCreateCommand);
        return "redirect:/users/";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id, @ModelAttribute UserUpdateCommand userUpdateCommand) {
        //userService.update(id, userUpdateCommand);
        return "redirect:/users/{id}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        //userService.delete(id)
        return "redirect:/users/";
    }

}