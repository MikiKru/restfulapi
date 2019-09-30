package com.atos.rest_start.service;

import com.atos.rest_start.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

// klasa implementująca logikę biznesowa dla kontrolera -> UserController
@Service
public class UserService {
    /*
    1. POST -> dodaj usera do listy users
    2. GET -> pobierz zawartość listy getAll()
    3. GET -> wyszukaj i zwróć w JSON usera z listy po user_id
     */

    private List<User> users = new ArrayList<>();

    public User addNewUser(String name, String lastname){
        User user = new User(name, lastname);
        users.add(user);
        return user;
    }
    public List<User> getAllUsers(){
        return users;
    }
    public User getUserById(Long id){
        for (User user : users){
            if(user.getUser_id().equals(id)){
                return user;
            }
        }
        return null;
    }
    // optional może zawierać obiekt klasy user lub null
    public Optional<User> getUserByIdStrem(Long id){
        return users.stream()
                .filter(user -> user.getUser_id().equals(id))
                .findAny();
    }
}
