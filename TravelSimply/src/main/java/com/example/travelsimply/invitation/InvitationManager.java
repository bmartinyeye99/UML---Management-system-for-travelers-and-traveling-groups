package com.example.travelsimply.invitation;

import com.example.travelsimply.HelloApplication;
import com.example.travelsimply.storage.Storage;
import com.example.travelsimply.trip.Trip;
import com.example.travelsimply.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class InvitationManager {

    @FXML
    private TextField invited;

    @FXML
    private Button sendBtn;

    @FXML
    private Text notFoundUser;

    @FXML
    private Text emptyName;

    @FXML
    private Text alreadyIn;

    @FXML
    private CheckBox access;

    private Trip trp;

    /*
    function checks whether any name was entered and if the traveler wasnt already added to the trip
    or the user didnt tried to invite himself
     */
    @FXML
    private void sendInvitation(ActionEvent event){
        if (invited.getText().isEmpty())
            emptyName.setVisible(true);

        User specator = Storage.UserSearch(invited.getText());

         if (specator == null) {
            notFoundUser.setVisible(true);

         }

        else if (!trp.invitedTravelers().contains(specator) && !trp.getTraveler().equals(invited.getText())){
            trp.setSpecators(specator,access.isSelected());

        }

        else alreadyIn.setVisible(true);


    }

    @FXML
    private void cancelInvitation(ActionEvent event) throws IOException {
        HelloApplication.switchToMenu(event,HelloApplication.loggedInUser);
    }

    public void initData(Trip trip) {
        trp = trip;
    }
}
