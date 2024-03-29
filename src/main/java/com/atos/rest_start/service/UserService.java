package com.atos.rest_start.service;

import com.atos.rest_start.model.User;
import com.atos.rest_start.model.enums.RoleEnum;
import org.springframework.stereotype.Service;

import java.util.*;

// klasa implementująca logikę biznesowa dla kontrolera -> UserController
@Service
public class UserService {
    /*
    1. POST -> dodaj usera do listy users
    2. GET -> pobierz zawartość listy getAll()
    3. GET -> wyszukaj i zwróć w JSON usera z listy po user_id
    -----------------------------------------------------------
    4. PUT -> zmień status na przeciwny i zwróć usera po user_id
    5. DELETE -> zwróć użytkownika po user_id i usuń go z listy
    6. PUT -> zmień rolę użytkownika na rolę przekazaną w parametrze żądania
    -----------------------------------------------------------
    7. Dodaj do klasy użytkownika sekwencję przechowującą role użytkownika (relacja many to many)
    -> zaimplementuj end-piont za pomocą którego można dodawać lub usuwać uprawnienia dla użytkownika
     */

    private List<User> users = new ArrayList<>();

    // dodaj rolę do zbioru ról
    public void addRoleToUserRoles(Long user_id, RoleEnum role){
        if(users.stream().filter(user -> user.getUser_id().equals(user_id)).findAny().isPresent()) {
            users.stream()
                    .filter(user -> user.getUser_id().equals(user_id)).findAny()
                    .get()
                    .addRole(role);
        }
    }
    public void subRoleFromUserRoles(Long user_id, RoleEnum role){
        if(users.stream().filter(user -> user.getUser_id().equals(user_id)).findAny().isPresent()) {
            users.stream()
                    .filter(user -> user.getUser_id().equals(user_id)).findAny()
                    .get()
                    .subRole(role);
        }
    }
    // usuń rolę z zbioru ról

//    public void updateUserRole(Long user_id, RoleEnum role){
//        if(getUserByIdStrem(user_id).isPresent()){
//            getUserByIdStrem(user_id).get().setRole(role);
//        }
//    }

    public User updateUserById(Long user_id){
        // wyszukaj usera po id
        Optional<User> updatedOptional = getUserByIdStrem(user_id);
        if(updatedOptional.isPresent()){
            User updatedUser = updatedOptional.get();
            // zmodyfikuj status i zaktualizuj listę
            updatedUser.setStatus(!updatedUser.getStatus());
//            // zaktualizowanie listy - opcjonalnie!!!
//            users.set(users.indexOf(updatedUser) , updatedUser);
            return updatedUser;
        }
        return new User(null,null,null,null, null);
    }
    public void removeUserById(Long user_id){
        if(getUserByIdStrem(user_id).isPresent()) {
            users.remove(getUserByIdStrem(user_id).get());
        }
    }

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
