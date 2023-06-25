/*
this class contains data holders of all entities such
as trips, users...etc
it implements a search interface as in my Classdiagram.
 */
package com.example.travelsimply.storage;

import com.example.travelsimply.Search;
import com.example.travelsimply.trip.City;
import com.example.travelsimply.trip.Country;
import com.example.travelsimply.trip.Trip;
import com.example.travelsimply.user.User;

import java.util.ArrayList;

public class Storage implements Search {

    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Trip> trips = new ArrayList<Trip>();

    public static ArrayList<City> cities = new ArrayList<City>();

    public static ArrayList<Country> countries = new ArrayList<Country>();


    public static User UserSearch(String username, String password) {
        for (User user: users){

            if (username.equals(user.getUsername()) && password.equals(user.getPassword())){

                return user;
            }
        }
        return null;
    }

    public static User UserSearch(String username) {
        for (User user: users){

            if (username.equals(user.getUsername()) ){
                return user;
            }
        }
        return null;
    }



}
