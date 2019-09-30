package com.atos.rest_start.model;

// klasa modelu - determinuje strukturę danych
// implementuje wzorzec java beans
// -> prywatne pola
// -> publiczne gettery / settery   ALT + Ins
// -> konstruktory                  ALT + Ins
// -> toString                      ALT + Ins
public class User {
    public static int id;
    private int user_id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
