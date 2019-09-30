package com.atos.rest_start.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.status = false;
        id++;
        this.user_id = id;
    }
}
