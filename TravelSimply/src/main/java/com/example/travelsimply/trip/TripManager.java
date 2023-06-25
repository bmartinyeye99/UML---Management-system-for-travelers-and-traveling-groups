package com.example.travelsimply.trip;

import com.example.travelsimply.storage.Storage;
import javafx.collections.ObservableList;

import static com.example.travelsimply.storage.Storage.trips;

public class TripManager {


    public static Trip createTrip(String user, String tripname, String destination, String destinationcity){
        Trip newtrip = new Trip(user,  tripname, destination, destinationcity);
        trips.add(newtrip);
        return newtrip;
    }

    public static void ReturnTrip(ObservableList ownTrips, String traveler) {
        for (Trip trip: trips){
            if (traveler.equals(trip.getTraveler()) || trip.invitedTravelers().contains(Storage.UserSearch(traveler)) ){
                ownTrips.add(trip);

            }
        }
    }




}
