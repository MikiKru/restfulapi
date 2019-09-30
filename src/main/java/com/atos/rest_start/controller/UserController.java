package com.atos.rest_start.controller;

import com.atos.rest_start.model.User;
import com.atos.rest_start.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

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
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/user/{user_id}")
    public User getUserById(@PathVariable Long user_id){
        Optional<User> user = userService.getUserByIdStrem(user_id);
        // sprawdzenie czy optional zawiera wartość niepustą
        if(user.isPresent()){
            // metoda get() wydobywa wartść z Optionala
            return user.get();
        }
        return new User(null,null);
        // wersja zz wyrażeniem lambda
        // return user.orElseGet(() -> new User(null, null));
    }
}
