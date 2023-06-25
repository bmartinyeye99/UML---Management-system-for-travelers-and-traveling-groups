package com.example.travelsimply.trip;

public class City {
    String name;
    String country;
    String info;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getInfo() {
        return info;
    }

    public City(String name, String country, String info) {
        this.name = name;
        this.country = country;
        this.info = info;
    }
}
