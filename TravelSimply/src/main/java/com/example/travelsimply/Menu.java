package com.example.travelsimply;

import com.example.travelsimply.trip.Trip;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import static com.example.travelsimply.HelloApplication.loggedInUser;
import static com.example.travelsimply.trip.TripManager.ReturnTrip;
import static com.example.travelsimply.trip.TripManager.createTrip;

public class Menu implements Initializable{

    @FXML
    private Text username;

    @FXML
    private TextField destinationField;

    @FXML
    private TextField tripnameField;
    @FXML
    private TextField destinationCityField;

    @FXML
    private TableView<Trip> tripTable;

    @FXML
    private TableColumn<Trip, String> inviteds;

    @FXML
    private TableColumn<Trip, String> travelerCol;

    @FXML
    private TableColumn<Trip, String> destinationCol;

    @FXML
    private TableColumn<Trip, String> cityCol;

    @FXML
    private TableColumn<Trip, String> tripnameCol;

    @FXML
    public Button inviteBtn;

    @FXML
    private Text notCollabtxt;

    // selected row/trip from the table
    private Trip selectedTrip;






//    private <event> void addButtonToTable() {
//
//        TableColumn<Trip, Void> details  = new TableColumn<>();
//
//        Callback<TableColumn<Trip, Void>, TableCell<Trip, Void>> cellFactory = new Callback<>() {
//            @Override
//            public TableCell<Trip, Void> call(final TableColumn<Trip, Void> param) {
//                return new TableCell<>() {
//
//
//                    private final Button openButton = new Button("Open");
//                    {
//                        openButton.setOnAction((ActionEvent event) -> {
//                            selecteedTrip = tripTable.getItems().get(getIndex()).getID();
//                            try {
//                                openDetails(event);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(openButton);
//                        }
//                    }
//                };
//            }
//        };
//
//        details.setCellFactory(cellFactory);
//
//        tripTable.getColumns().add(details);
//
//
//    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setText(loggedInUser.getUsername());
        travelerCol.setCellValueFactory(new PropertyValueFactory<>("traveler"));
        tripnameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        destinationCol.setCellValueFactory(new PropertyValueFactory<>("destination"));
        cityCol.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
        inviteds.setCellValueFactory(new PropertyValueFactory<>("stringSpecators")); //getStringSpecators


        ObservableList<Trip> tableTrips = tripTable.getItems();
        ReturnTrip(tableTrips, loggedInUser.getUsername());
        tripTable.setItems(tableTrips);


    }


    /*
    function creates the newly created trip among the other trips of the
    user, and also refreshes the tableview

     */

    @FXML
    private void saveTrip(ActionEvent event){
        ObservableList<Trip> tableTrips = tripTable.getItems();
        Trip trip = createTrip(loggedInUser.getUsername(), tripnameField.getText(),
                                destinationField.getText(),destinationCityField.getText());
        tableTrips.add(trip);
        tripTable.setItems(tableTrips);
        tripnameField.clear();
        destinationField.clear();
        destinationCityField.clear();

    }


    /*
    a row has to be selected, then the Invite traveler button triggers the function
    which switches to the invitation window.
     */
    @FXML
    private void createInvitation(ActionEvent event) throws IOException {
            int selectedID = tripTable.getSelectionModel().getSelectedIndex();
            Trip selected = tripTable.getItems().get(selectedID);
            HelloApplication.switchInvitation(event, selected);

    }


    @FXML
    private void logOut(ActionEvent event) throws IOException {
        HelloApplication.switchToLogin(event);
    }

    /*
    selected trip is laoded to the textfields after the change trip button is clicked
     */
    @FXML
    private void changeTrip(ActionEvent event)throws IOException{
        int selectedID = tripTable.getSelectionModel().getSelectedIndex();
        selectedTrip = tripTable.getItems().get(selectedID);

        if (selectedTrip != null  ){
            destinationCityField.setText(selectedTrip.getDestinationCity());
            destinationField.setText(selectedTrip.getDestination());
            tripnameField.setText(selectedTrip.getName());
        }


    }

    /*
    function saves the changes after a laoded trip was changed
    trip has to be selected and loaded, textfield cannot be empty
     */
    @FXML
    private void saveChanges(ActionEvent event){

        if (selectedTrip==null )
            return;
        else {
            if (destinationField.getText().isEmpty() || destinationCityField.getText().isEmpty() || tripnameField.getText().isEmpty())
                return;
            else if (selectedTrip.checkCollab(loggedInUser) || selectedTrip.getTraveler().equals(loggedInUser.getUsername())){

                selectedTrip.setDestination(destinationField.getText());
                selectedTrip.setDestinationCity(destinationCityField.getText());
                selectedTrip.setName(tripnameField.getText());
                notCollabtxt.setVisible(false);


            }
            else
                notCollabtxt.setVisible(true);


        }
    }

    /*
    function clears the selection
     */
    @FXML
    private void clearSelection(ActionEvent event){
        tripTable.getSelectionModel().clearSelection();
        selectedTrip = null;

    }



}
