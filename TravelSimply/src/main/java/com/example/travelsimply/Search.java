package com.example.travelsimply;

import com.example.travelsimply.trip.Trip;
import com.example.travelsimply.user.User;

public interface Search {

    static User UserSearch(String username, String password) {
        return null;
    }

    static Trip ReturnTrip(String TraverlerID) {
        return null;
    }

    static User UserSearch(String username) {
        return null;
    }
}
