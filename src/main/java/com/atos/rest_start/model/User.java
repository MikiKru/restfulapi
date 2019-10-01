package com.atos.rest_start.model;

import com.atos.rest_start.model.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

// klasa modelu - determinuje strukturę danych
// implementuje wzorzec java beans
// -> prywatne pola
// -> publiczne gettery / settery   ALT + Ins
// -> konstruktory                  ALT + Ins
// -> toString                      ALT + Ins
@Data               // dodaje gettery settery
@NoArgsConstructor  // dodaje konstruktor domyślny
@AllArgsConstructor // dodaje konstruktor z wszystkimi argumentami
public class User {
    public static Long id = Long.valueOf(0);
    private Long user_id;
    private String name;
    private String lastname;
    private Boolean status;
    private Set<RoleEnum> roles = new HashSet<>();

    public void addRole(RoleEnum role){
        this.roles.add(role);
    }
    public void subRole(RoleEnum role){
        this.roles.remove(role);
    }

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.status = false;
        id++;
        this.user_id = id;
        // dodanie domyślnie roli user
        this.roles.add(RoleEnum.ROLE_USER);
    }
}
