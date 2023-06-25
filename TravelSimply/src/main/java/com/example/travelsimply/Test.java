package com.example.travelsimply;

import com.example.travelsimply.trip.City;
import com.example.travelsimply.trip.Country;
import com.example.travelsimply.trip.Trip;
import com.example.travelsimply.user.User;

import static com.example.travelsimply.storage.Storage.*;

public class Test {

   // public static Storage storage = new Storage();

    public static void CreateTests(){
        User u1 = new User("User1", "testuser@gmail.com", "u101", "1234");
        User u2 = new User("User2", "testuser2@gmail.com", "u202", "12345");
        User u3 = new User("User3", "testuser3@gmail.com", "u303", "123456");

        City c1 = new City("Paris", "France", "Eifel tower, Louvre");
        City c2 = new City("Prague", "Czech republic", "Karluv most, Orloj, Vaclavovo namesti");
        City c3 = new City("Rome", "Italy", "Colosseum, Forum Romanum, Angels Castle, Vatican");

        Country country1 = new Country("France", "No required vaccination");
        Country country2 = new Country("Czech republic", "No required vaccination");
        Country country3 = new Country("Italy", "No required vaccination");

        Trip trip1 = new Trip("User1","FranceTrip",country1.getName(), c1.getName());
        Trip trip2 = new Trip("User2","ItalyTrip",country3.getName(), c3.getName());

        users.add(u1);
        users.add(u2);
        users.add(u3);

        trips.add(trip1);
        trips.add(trip2);

        cities.add(c1);
        cities.add(c2);
        cities.add(c3);

        countries.add(country1);
        countries.add(country2);
        countries.add(country3);

//        System.out.printf("%s %s",trips.get(0).getTraveler(), trips.get(0).getDestinationCity());
//        System.out.printf("%s %s",trips.get(1).getTraveler(), trips.get(1).getDestinationCity());


    }
}
