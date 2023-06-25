package com.example.travelsimply.trip;

import com.example.travelsimply.storage.Storage;
import com.example.travelsimply.user.User;

import java.util.ArrayList;
import java.util.*;

public class Trip {
    private String traveler;

    private String travelerID;
    private String name;
    private String ID;
    private String destination;
    private String destinationCity;
    private String info;

    private Hashtable<String, Boolean> inviteds;

  //  private ArrayList<User> specators;


    public String getTraveler() {
        return traveler;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

//    public String getTravelerID() {
//        return travelerID;
//    }
//
//    public String getInfo() {
//        return info;
//    }
//
//    public String getID() {
//        return ID;
//    }



    // add new user and their aacces to the trip
    // to the hashtable of invited travelers
    public void setSpecators(User user, boolean access) {
        inviteds.put(user.getUsername(), access);
        System.out.println("New table is: " + inviteds);
    }


    /*
    function checks whether the user is among the invited users,
    if he is than it check if he is collaborator and returns ture, when he
    is not, than returns false.
     */
    public boolean checkCollab(User user){
        if(inviteds.containsKey(user.getUsername())) {
            Set<String> keys = inviteds.keySet();
            for (String key : keys) {
                if (inviteds.get(key).equals(true)) {
                    return true;

                } else
                    return false;
            }
        }

        return false;

    }

    // function returns list of all invited travelers
    public ArrayList<User> invitedTravelers() {
        Set<String> keys = inviteds.keySet();
        ArrayList<User> names = new ArrayList<User>();

        for (String key : keys) {
            names.add(Storage.UserSearch(key));

        }
        return names;
    }

    /*
    this function is used in the initiaize function in menu class
    this function fills the column of invited travelers and adds
    an * sign to the ones who are collaborators
     */
    public String getStringSpecators(){
        String s = " ";
        Set<String> keys = inviteds.keySet();
        for(String usr: keys){
            if (usr.equals(traveler))
                continue;
            if(inviteds.get(usr).equals(true))
                s += usr + "*, ";

            else
                s += usr + ", ";
        }

        return s;
    }


    public Trip(String traveler, String name,
                String destination, String destinationCity) {

        this.traveler = traveler;
       // this.travelerID = travelerID;
        this.name = name;
        this.destination = destination;
        this.destinationCity = destinationCity;
        //this.specators = new ArrayList<User>();
        this.inviteds = new Hashtable<String, Boolean>();

        //   this.info = info;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }


}
