package com.example.travelsimply.user;


import javafx.scene.control.Button;

public class User {

    private String username;
    private String email;
    private String ID;

    private String password;


    public User(String username, String email, String ID, String password) {
        this.username = username;
        this.email = email;
        this.ID = ID;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }
}
