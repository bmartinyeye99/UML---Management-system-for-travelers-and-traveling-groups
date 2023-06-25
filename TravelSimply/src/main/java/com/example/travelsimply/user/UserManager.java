package com.example.travelsimply.user;


import com.example.travelsimply.HelloApplication;
//import com.example.travelsimply.ScreenController;
import com.example.travelsimply.Test;
import com.example.travelsimply.storage.Storage;
import com.example.travelsimply.trip.City;
import com.example.travelsimply.trip.Country;
import com.example.travelsimply.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.travelsimply.storage.Storage.UserSearch;

public class UserManager {


    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginbutton;

    @FXML
    private Text loginErrormsg;

    private User loggedUser;
    //Storage storage = Test.storage;


    public void Login(ActionEvent event) throws IOException {
         String username = usernameField.getText();
         String password = passwordField.getText();
         loggedUser = UserSearch(username, password);

        if(loggedUser == null)
            loginErrormsg.setVisible(true);

         else {
            HelloApplication.loggedInUser = loggedUser;
            HelloApplication.switchToMenu(event, loggedUser);
        }
    }
}
