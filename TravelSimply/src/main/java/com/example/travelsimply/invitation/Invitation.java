package com.example.travelsimply.invitation;

public class Invitation {

    private String sender;
    private String reciever;
    private String trip;
    private boolean access;

    public Invitation(String sender, String reciever, String trip, boolean access) {
        this.sender = sender;
        this.reciever = reciever;
        this.trip = trip;
        this.access = access;
    }

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public String getTrip() {
        return trip;
    }

    public boolean isAccess() {
        return access;
    }
}
