package com.example.travelsimply;

import com.example.travelsimply.invitation.InvitationManager;
import com.example.travelsimply.trip.Trip;
import com.example.travelsimply.user.User;
import com.example.travelsimply.user.UserManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.travelsimply.Test.CreateTests;

public class HelloApplication extends Application {

    public static User loggedInUser;
    @Override
    public void start(Stage stage) throws IOException {
        UserManager test = new UserManager();
        CreateTests();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Travel simply!");
        stage.setScene(scene);

        stage.show();
    }

    public static void switchToLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        loggedInUser = null;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Travel simply!");
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);

        Menu controller = loader.getController();
        //controller.initData();

        stage.show();
    }

    public static void switchToMenu(ActionEvent event, User user) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Travel simply!");
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);

        Menu controller = loader.getController();
        //controller.initData();

        stage.show();
    }

    public static void switchInvitation(ActionEvent event,Trip trip) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("invitation.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        InvitationManager controller = loader.getController();
        controller.initData(trip);

        stage.show();
    }

//    public static void openDetails(User loggedUser, ActionEvent event) throws IOException {
//
//        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml/user_info.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setTitle("Travel simply");
//        Scene scene = new Scene(loader.load());
//        stage.setScene(scene);
//
//        Tripinfo controller = loader.getController();
//        controller.initData(loggedInUser, selectedUser);
//
//        stage.show();
//    }

    public static void main(String[] args) {
        launch();
    }
}