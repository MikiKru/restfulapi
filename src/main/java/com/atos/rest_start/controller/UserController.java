package com.atos.rest_start.controller;

import com.atos.rest_start.model.User;
import com.atos.rest_start.model.enums.RoleEnum;
import com.atos.rest_start.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RequestMapping("/user")
@RestController
@AllArgsConstructor
public class UserController {
    // mechanizm wstrzykiwania zależności
    @Autowired
    private UserService userService;

    @PutMapping("add/role/{user_id}")
    public String addRole(
            @PathVariable Long user_id,
            @RequestParam RoleEnum role
    ){
        userService.addRoleToUserRoles(user_id,role);
        return "grant permission " + role;
    }
    @PutMapping("sub/role/{user_id}")
    public String subRole(
            @PathVariable Long user_id,
            @RequestParam RoleEnum role
    ){
        userService.subRoleFromUserRoles(user_id,role);
        return "subtract permission " + role;
    }

//    @PutMapping("/update/role/{user_id}")
//    public ResponseEntity updateUserRole(
//            @PathVariable Long user_id,
//            @RequestParam RoleEnum role){
//        userService.updateUserRole(user_id, role);
//        return ResponseEntity.ok(200);
//    }

    @PutMapping("/update/{user_id}")
    public User updateUserById(@PathVariable Long user_id){
        return userService.updateUserById(user_id);
    }
    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity deleteUserbyId(@PathVariable Long user_id){
        userService.removeUserById(user_id);
        return ResponseEntity.ok(200);
    }

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
        return new User(null,null,null,null, null);
        // wersja zz wyrażeniem lambda
        // return user.orElseGet(() -> new User(null, null));
    }

}
