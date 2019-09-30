package com.atos.rest_start.controller;

import com.atos.rest_start.model.User;
import com.atos.rest_start.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@AllArgsConstructor
public class UserController {
    // mechanizm wstrzykiwania zależności
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User addNewUser(@RequestParam String name, @RequestParam String lastname){
        return userService.addNewUser(name,lastname);
    }
}
